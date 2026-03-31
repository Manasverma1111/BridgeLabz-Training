import java.util.ArrayList;
import java.util.Arrays;

public class ProdOfArrExceptSelf {

    public static int[] calcProd(int[] nums) {

        int n = nums.length;
        int[] newArr = new int[n];

        int leftProd = 1;
        for (int i = 0; i < n; i++) {
            newArr[i] = leftProd;
            leftProd *= nums[i];
        }

        int rightProd = 1;
        for (int j = n - 1; j >= 0; j--) {
            newArr[j] *= rightProd;
            rightProd *= nums[j];
        }

        return newArr;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int[] res = calcProd(nums);
        System.out.println(Arrays.toString(res));
    }
}
