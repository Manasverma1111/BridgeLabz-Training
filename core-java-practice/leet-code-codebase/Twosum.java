import java.util.Scanner;

public class Twosum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
//        take input for the array length
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
//        take input for the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
//        take input for the target value
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        int[] res = twoSum(nums, target);

        if (res.length == 0) {
            System.out.println("No solution found.");
        } else {
            System.out.println("Indices of the two numbers are: " + res[0] + " and " + res[1]);
        }

    }
}
