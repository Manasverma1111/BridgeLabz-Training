package linear_binary_search;

public class FirstNegativeNumber {

    public static int firstNegative(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {2, 4, -3, 8, -11};
        int res = firstNegative(arr);

        if (res != -1) {
            System.out.println("at index: " + res);
        } else {
            System.out.println("Not found");
        }
    }
}
