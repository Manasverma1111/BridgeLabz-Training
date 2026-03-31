package linear_binary_search;

import java.util.Arrays;

public class FirstMissingPositiveNum {

    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;
        boolean[] visited = new boolean[n + 1];

        for (int num : nums) {
            if (num > 0 && num <= n) {
                visited[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }

        return n + 1;
    }

    public static int findIndex(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, -1, 1};

        int res = firstMissingPositive(arr);
        System.out.println(res);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int index = findIndex(arr, 4);
        System.out.println("index: " + index);
    }
}
