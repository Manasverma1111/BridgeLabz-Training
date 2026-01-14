package sortingAlgorithms;

public class MergeSort {

    public static void mergeSortBookPrice(int[] price, int left, int right) {

        int n = price.length;
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSortBookPrice(price, left, mid);
            mergeSortBookPrice(price, mid + 1, right);
            mergeSort(price, left, mid, right);
        }
    }

    public static void mergeSort(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {

        int[] prices = {40, 57, 21, 34, 50, 28};
        mergeSortBookPrice(prices, 0, prices.length - 1);

        for (int num : prices) {
            System.out.print(num + " ");
        }
    }

}
