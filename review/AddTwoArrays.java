import java.util.Arrays;

public class AddTwoArrays {

    public static int[] addArrays(int[] arr1, int[] arr2) {

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;

        int maxLen = Math.max(arr1.length, arr2.length);
        int[] result = new int[maxLen + 1];

        int k = result.length - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum += arr1[i--];
            }

            if (j >= 0) {
                sum += arr2[j--];
            }

            result[k--] = sum % 10;
            carry = sum / 10;
        }

        result[k] = carry;

        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 9, 8};
        int[] arr2 = {7, 6, 5};

        int[] sum = addArrays(arr1, arr2);
        System.out.println(Arrays.toString(sum));
    }
}
