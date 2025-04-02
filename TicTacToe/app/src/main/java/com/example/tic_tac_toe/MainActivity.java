package com.example.tic_tac_toe;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.tic_tac_toe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private final List<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;
    private SharedPreferences preferences;
    private int playerOneWins;
    private int playerTwoWins;
    private TextView playerOneName;
    private TextView playerTwoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoName);

        Intent intent = getIntent();
        String playerOne = intent.getStringExtra("playerOne");
        String playerTwo = intent.getStringExtra("playerTwo");

        if (playerOne != null && playerTwo != null) {
            playerOneName.setText(playerOne);
            playerTwoName.setText(playerTwo);
        }

        preferences = getSharedPreferences("TicTacToePrefs", MODE_PRIVATE);
        playerOneWins = preferences.getInt("playerOneWins", 0);
        playerTwoWins = preferences.getInt("playerTwoWins", 0);

        updateScoreboard();

        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{0, 4, 8});
        combinationList.add(new int[]{2, 4, 6});

        binding.resetScoreButton.setOnClickListener(view -> resetScores());

        setClickListeners();
    }
    private void setClickListeners() {
        ImageView[] boxes = {binding.image1, binding.image2, binding.image3,
                binding.image4, binding.image5, binding.image6,
                binding.image7, binding.image8, binding.image9};
        for (int i = 0; i < boxes.length; i++) {
            final int index = i;
            boxes[i].setOnClickListener(view -> {
                if (isBoxSelectable(index)) {
                    performAction((ImageView) view, index);
                }
            });
        }
    }
    private void performAction(ImageView imageView, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = playerTurn;

        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.ximage);
            if (checkResult()) {
                playerOneWins++;
                saveScores();
                showResult(binding.playerOneName.getText().toString() + " is a Winner!");
            } else if (totalSelectedBoxes == 9) {
                showResult("Match Draw!");
            } else {
                changePlayerTurn((playerTurn == 1) ? 2 : 1);
                totalSelectedBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.oimage);
            if (checkResult()) {
                playerTwoWins++;
                saveScores();
                showResult(binding.playerTwoName.getText().toString() + " is a Winner!");
            } else if (totalSelectedBoxes == 9) {
                showResult("Match Draw!");
            } else {
                changePlayerTurn((playerTurn == 1) ? 2 : 1);
                totalSelectedBoxes++;
            }
        }
    }
    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;
        if (playerTurn == 1){
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box);
        }else{
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }
    }
    private boolean checkResult() {
        for (int[] combination : combinationList) {
            if (boxPositions[combination[0]] == playerTurn &&
                    boxPositions[combination[1]] == playerTurn &&
                    boxPositions[combination[2]] == playerTurn) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoxSelectable(int boxPosition){
        boolean response = false;
        if (boxPositions[boxPosition] == 0){
            response = true;
        }
        return response;
    }
    public void restartMatch(){
        boxPositions = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        playerTurn = 1;
        totalSelectedBoxes = 1;

        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);
    }

    private void saveScores() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("playerOneWins", playerOneWins);
        editor.putInt("playerTwoWins", playerTwoWins);
        editor.apply();
        updateScoreboard();
    }

    private void updateScoreboard() {
        binding.playerOneScore.setText("Wins: " + playerOneWins);
        binding.playerTwoScore.setText("Wins: " + playerTwoWins);
    }

    private void resetScores() {
        playerOneWins = 0;
        playerTwoWins = 0;
        saveScores();
    }

    private void showResult(String message) {
        ResultDialog resultDialog = new ResultDialog(MainActivity.this, message, MainActivity.this);
        resultDialog.setCancelable(false);
        resultDialog.show();
    }
}