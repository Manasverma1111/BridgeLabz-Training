package stackqueue;

import java.util.Stack;

class QueueUsingStack {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    public void enQueue(int n) {
        inStack.push(n);
    }
    public int deQueue() {
        if (outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        }

        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()) {
            return -1;
        }

        return outStack.peek();
    }

    public static void main(String[] args) {

        QueueUsingStack q = new QueueUsingStack();

        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);

        System.out.println(q.deQueue()); // 10
        System.out.println(q.deQueue()); // 20

        q.enQueue(40);

        System.out.println(q.deQueue()); // 30
        System.out.println(q.peek());    // 40
    }
}
