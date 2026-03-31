import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeros(int[] nums) {

        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[count];
                nums[count] = temp;
                count++;
            }
        }

        System.out.println(Arrays.toString(nums));

//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] != 0) {
//                nums[count] = nums[i];
//                count++;
//            }
//        }
//
//        for (int i = count; i < n; i++) {
//            nums[i] = 0;
//        }
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        moveZeros(nums);
    }
}
