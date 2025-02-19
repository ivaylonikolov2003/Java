import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ServerRunnable implements Runnable {
    Socket client;
    Scanner clientInput;
    PrintStream clientOutput;
    static final Object mutexLock = new Object();

    public ServerRunnable(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            clientInput = new Scanner(client.getInputStream());
            clientOutput = new PrintStream(client.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            clientOutput.println("Enter a option");
            clientOutput.println("1.Create a regex");
            clientOutput.println("2.Search a regex by a keyword");

            int initialChoice = Integer.parseInt(clientInput.nextLine());

            switch (initialChoice) {
                case 1:
                    CreateRegex();
                    break;
                case 2:
                    SearchRegex();
                    break;
                default:
                    clientOutput.println("Enter a valid number.");
                    break;
            }
        }
    }

    void CreateRegex() {
        clientOutput.println("Enter regex pattern");
        String pattern = clientInput.nextLine();

        clientOutput.println("Enter regex description");
        String description = clientInput.nextLine();

        clientOutput.println("Enter amount of tests");
        int testAmount = Integer.parseInt(clientInput.nextLine());

        String[] testString = new String[testAmount];

        for (int i = 0; i < testAmount; i++) {
            clientOutput.println("Enter test #" + (i + 1));
            testString[i] = clientInput.nextLine();
        }

        Regex newRegex = new Regex(pattern, description);
        List<Boolean> results = RegexTester.test(newRegex, testString);
        clientOutput.println(Arrays.toString(results.toArray()));

        clientOutput.println("Do you want to add this regex to the file? (y/n)");
        String addToFileChoice = clientInput.nextLine().toLowerCase();

        if (addToFileChoice.equals("y")) {
            synchronized (mutexLock) {
                List<Regex> currentInFile;

                currentInFile = Regex.readFromFile();
                if (currentInFile.stream().anyMatch(regex -> regex.getPattern().equals(pattern))) {
                    clientOutput.println("Pattern is already in file!");
                } else {
                    currentInFile.add(newRegex);
                    Regex.writeToFile(currentInFile);
                }
            }

        }
    }

    void SearchRegex(){
        clientOutput.println("Enter a keyword: ");
        String keyword = clientInput.nextLine();

        synchronized (mutexLock){
            List<Regex> currentInFile = Regex.readFromFile();
            List<Regex> resultList = currentInFile.stream()
                    .filter(regex -> regex.getDescription().contains(keyword))
                    .sorted((a, b) -> b.getRating() - a.getRating())
                    .toList();

            if (resultList.isEmpty()){
                clientOutput.println("List is empty");
            }

            for (int i = 0; i < resultList.size(); i++) {
                clientOutput.println("#" + (i + 1) + " " + resultList.get(i).toString());
            }

            clientOutput.println("Pick a digit from the menu above to select a Regex");
            int selectedDigit = Integer.parseInt(clientInput.nextLine()) - 1;

            Regex selectedRegex = resultList.get(selectedDigit);

            clientOutput.println("Enter a number of tests");
            int testAmount = Integer.parseInt(clientInput.nextLine());;


            String[] testStrings = new String[testAmount];
            for (int i = 0; i < testAmount; i++) {
                clientOutput.println("Enter test #" + (i + 1));
                testStrings[i] = clientInput.nextLine();
            }

            List<Boolean> results = RegexTester.test(selectedRegex, testStrings);
            clientOutput.println(Arrays.toString(results.toArray()));

            clientOutput.println("(I)ncrease, (D)ecrease, (N)o");
            String choice = clientInput.nextLine().toUpperCase();

            switch (choice) {
                case "I":
                    selectedRegex.setRating(selectedRegex.getRating() + 1);
                    break;
                case "D":
                    selectedRegex.setRating(selectedRegex.getRating() - 1);
                    break;
                case "N":
                default:
                    return;
            }

            Regex.writeToFile(currentInFile);
        }
    }
}
