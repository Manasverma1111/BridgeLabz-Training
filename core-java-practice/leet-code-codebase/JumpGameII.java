import java.util.Scanner;
public class JumpGameII {

    public static int countJump(int[] nums) {

        int jumpCount = 0;
        int maxReach = 0;
        int last = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == last) {
                jumpCount++;
                last = maxReach;
            }
        }

        return jumpCount;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for array size and its elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int res = countJump(nums);
        System.out.println("Minimum jumps required: " + res);
    }
}

