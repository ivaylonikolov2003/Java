import java.util.Scanner;

public class FirstExeptio {
    public static void main(String[] args) {
        try {
            System.out.print("Please enter a number: ");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String lineParts[] = line.split(" ");
            int num1 = Integer.parseInt(lineParts[1]);

            System.out.print("Please enter another number: ");
            line = scanner.nextLine();
            int num2 = Integer.parseInt(line);

            System.out.println("num1 * num2 = " + (num1 * num2));
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Invalid index (out of bounds)");
        }catch (IllegalArgumentException iaex){
            System.out.println("Invalid number");
        }
    }
}
