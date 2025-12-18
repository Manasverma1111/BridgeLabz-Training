import java.util.Scanner;

class twosum {
    public int[] twoSum(int[] nums, int target) {
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
        Scanner scanner = new Scanner(System.in);

        // Take input for the array length
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] nums = new int[n];

        // Take input for the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Take input for the target value
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        // Create an instance of Solution and call the twoSum method
        twosum solution = new twosum();
        int[] result = solution.twoSum(nums, target);

        // Print the result
        if (result.length == 0) {
            System.out.println("No solution found.");
        } else {
            System.out.println("Indices of the two numbers are: " + result[0] + " and " + result[1]);
        }

        scanner.close();
    }
}
