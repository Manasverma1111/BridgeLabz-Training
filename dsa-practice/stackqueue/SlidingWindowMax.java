package stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {

    static void printMaxInWindows(int[] arr, int k) {

        if (arr == null || k <= 0 || k > arr.length) {
            return;
        }

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= k - 1) {
                System.out.print(arr[dq.peekFirst()] + " ");
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        printMaxInWindows(arr, k);
    }
}
