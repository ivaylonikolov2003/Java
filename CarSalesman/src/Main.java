import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenght = 0;
        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();
        boolean hasNumber;

        for (int i = 0; i < n; i++) {
            String[] cmdParts = scanner.nextLine().split(" ");
            String engModel = cmdParts[0];
            String power = cmdParts[1];
            String weight = "n/a";
            String color = "n/a";
            lenght = cmdParts.length;

            if (lenght == 3){
                String current = cmdParts[2];
                hasNumber = checkForNumbers(current);
                if (hasNumber){
                    weight = current;
                }
                else {
                    color = current;
                }
            }
            if(lenght == 4){
                weight = cmdParts[2];
                color = cmdParts[3];
            }



        }
    }

    private static boolean checkForNumbers(String current){
        for (int i = 0; i < current.length(); i++) {
            int ascii = current.charAt(i);
            if (ascii > 47 && ascii < 58){
                return true;
            }
        }
        return false;
    }
}
