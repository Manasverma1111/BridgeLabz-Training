public class MissingNumber {

    public static int missingNumber(int[] nums) {

        int n = nums.length;
        int xor = n;

        for (int i = 0; i < n; i++) {
            xor ^= i;
            xor ^= nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {

        int[] nums = {3, 0, 1};
        int res = missingNumber(nums);
        System.out.print("missing number: " + res);
    }
}
