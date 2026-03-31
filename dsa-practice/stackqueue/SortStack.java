package stackqueue;
import java.util.Stack;

public class SortStack {

    static void sortStack(Stack<Integer> stk) {
        if (stk.isEmpty()) {
            return;
        }

        int top = stk.pop();
        sortStack(stk);
        insertSorted(stk, top);

    }

    static void insertSorted(Stack<Integer> stk, int n) {
        if (stk.isEmpty() || stk.peek() <= n) {
            stk.push(n);
            return;
        }

        int top = stk.pop();
        insertSorted(stk, n);
        stk.push(top);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        sortStack(stack);

        System.out.println(stack);
//        while (!stack.isEmpty()) {
//            System.out.print(stack.pop() + " ");
//        }
    }
}
