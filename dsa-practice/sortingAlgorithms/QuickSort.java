package sortingAlgorithms;

public class QuickSort {

    public static void quickSortPrices(int[] prices, int left, int right) {

        if (left < right) {
            int pivotIdx = partition(prices, left, right);

            quickSortPrices(prices, left, pivotIdx - 1);
            quickSortPrices(prices, pivotIdx + 1, right);
        }
    }
    public static int partition(int[] prices, int left, int right) {

        int pivot = prices[left];
        int i = left + 1;

        for (int j = left + 1; j <= right; j++) {
            if (prices[j] < pivot) {
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;

                i++;
            }
        }

        int temp = prices[left];
        prices[left] = prices[i - 1];
        prices[i - 1] = temp;

        return i - 1;
    }

    public static void main(String[] args) {

        int[] prices = {37, 19, 11, 51, 42};
        quickSortPrices(prices, 0, prices.length - 1);

        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
}
