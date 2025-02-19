import java.util.ArrayList;
import java.util.List;

public class CommonInteger {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] nums1 = {9, 3, 6, 1, 2, 4};

        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums[i] == nums1[j]){
                    integers.add(nums[i]);
                }
            }
        }

        System.out.print("Common elements are: ");
        for (Integer i:integers) {
            System.out.print(i + " ");
        }
    }
}
