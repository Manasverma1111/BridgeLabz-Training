package sortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSortId(int[] ids) {

        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int k = ids[i];
            int j = i - 1;

            while (j >= 0 && ids[j] > k) {
                ids[j + 1] = ids[j];
                j--;
            }

            ids[j + 1] = k;
        }
    }

    public static void main(String[] args) {

        int[] ids = {3, 2, 9, 1, 6};
        insertionSortId(ids);
        System.out.println(Arrays.toString(ids));
    }
}
