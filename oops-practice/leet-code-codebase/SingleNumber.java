public class SingleNumber {

    public static int singleNumber(int[] nums) {

        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 2};
        int res = singleNumber(nums);
        System.out.println("single missing number: " + res);
    }
}
