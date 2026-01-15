package sortingAlgorithms;

import java.util.Arrays;

public class CountingSort {

    public static void countingSortAges(int[] ages) {

        int n = ages.length;
        int max = ages[0];

        for (int age : ages) {
            if (age > max) {
                max = age;
            }
        }

        int[] count = new int[max + 1];
        for (int age : ages) {
            count[age]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[count[ages[i]] - 1] = ages[i];
            count[ages[i]]--;
        }

        System.arraycopy(res, 0, ages, 0, n);

    }

    public static void main(String[] args) {

        int[] arr = {14, 12, 12, 18, 13, 13, 11, 15, 16, 16, 15, 17, 10, 15, 18, 11, 11, 11, 11, 16};

        countingSortAges(arr);
        System.out.println(Arrays.toString(arr));
    }
}
