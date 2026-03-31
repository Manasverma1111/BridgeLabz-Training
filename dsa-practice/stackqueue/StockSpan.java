package stackqueue;

import java.util.Stack;

public class StockSpan {

    static void calcSpan(int[] price) {
        int n = price.length;
        int[] span = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && price[stk.peek()] <= price[i]) {
                stk.pop();
            }
            span[i] = stk.isEmpty() ? (i + 1) : (i - stk.peek());
            stk.push(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(span[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] price = {100, 80, 60, 70, 60, 75, 85};
        calcSpan(price);
    }
}
