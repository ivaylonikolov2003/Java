import java.util.Scanner;
import java.util.Arrays;
public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] train = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {

            int people = Integer.parseInt(scanner.nextLine());
            train[i] = people;
            sum += people;
        }

        for (int i = 0; i < train.length; i++) {
            System.out.printf("%d ", train[i]);
        }
        System.out.println();
        System.out.println(sum);
    }

}
