package linear_binary_search;

public class FirstAndLastIndex {

    public static int findFirst(int[] arr, int target) {

        int left = 0;
        int right = arr.length;
        int res = -1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                res = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    public static int findLast(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                res = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
    }
}

