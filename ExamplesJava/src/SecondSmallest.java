import java.util.Arrays;

public class SecondSmallest {
    public static void main(String[] args) {
        int[] numbers = {-1, 4, 0, 2, 7, -3};

        System.out.println("Original list: " + Arrays.toString(numbers));

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;


        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == min){
                secondMin = min;
            }else if (numbers[i] < min){
                secondMin = min;
                min = numbers[i];
            } else if (numbers[i] < secondMin) {
                secondMin = numbers[i];
            }
        }
        System.out.println("Second smallest element is: " + secondMin);
    }
}
