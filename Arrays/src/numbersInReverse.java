import java.util.Scanner;
public class numbersInReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of array: ");
        int number = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[number];

        for (int i = 0; i < number; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            arr[i] = num;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

    }
}
