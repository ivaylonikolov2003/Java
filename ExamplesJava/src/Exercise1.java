import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a lenght of a array: ");
        int number = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            numbers.add(num);
        }

        int sum = 0;
        int largestNum = 0;

        System.out.print("[ ");
        for (Integer num:numbers) {
            if (num > largestNum)
            {
                largestNum = num;
            }
            sum += num;
            System.out.printf("%d ", num);
        }
        System.out.println("]");

        System.out.println("The sum is: " + sum);
        System.out.println("The largest num is: " + largestNum);
    }

}
