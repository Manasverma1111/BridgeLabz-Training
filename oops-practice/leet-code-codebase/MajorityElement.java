public class MajorityElement {

    public static int majorityElmt(int[] nums) {

        int count = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                max = nums[i];
            }
            if (nums[i] == max) {
                count++;
            } else {
                count--;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 2, 3};
        int res = majorityElmt(nums);
        System.out.println("majority element: " + res);
    }
}
