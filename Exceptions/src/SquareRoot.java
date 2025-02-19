import java.util.Scanner;

public class SquareRoot {

    public static double calcSqrt(double value){
        if (value < 0)
            throw new IllegalArgumentException("Sqrt for negative numbers is undefined!");
        return Math.sqrt(value);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String line = scanner.nextLine();
            int num = Integer.parseInt(line);
            double result = calcSqrt(num);
            System.out.printf("%.2f\n", result);
        }catch (Exception ex){
            System.out.println("Invalid");
        }finally {
            System.out.println("Goodbye");
        }
    }
}
