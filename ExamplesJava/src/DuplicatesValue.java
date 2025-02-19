import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DuplicatesValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size of list: ");
        int size = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter a numbers:");
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            numbers.add(num);
        }

        for (int i = 0; i < numbers.size() + 1; i++) {
            for (int j = i+1; j < numbers.size(); j++) {
                if (numbers.get(i) == numbers.get(j) && (i != j)){
                    System.out.println("Duplicate values: " + numbers.get(j));
            }
            }
        }
    }
}
