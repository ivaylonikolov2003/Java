import java.util.Arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] numbers = {10789, 2035, 1899, 1456, 2013,
                1458, 2458, 1254, 1472, 2365,
                1456, 2165, 1457, 2456};

        System.out.println("Original list: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("List after sorting: " + Arrays.toString(numbers));
        int index = numbers.length - 1;

        while (numbers[index] == numbers[numbers.length - 1]){
            index--;
        }

        System.out.println("Second largest element is: " + numbers[index]);
    }
}
