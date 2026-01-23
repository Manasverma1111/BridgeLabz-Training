package interfaces;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    public Queue<Integer> q1 = new LinkedList<>();
    public Queue<Integer> q2 = new LinkedList<>();

    public void push(int value) {
        q2.offer(value);

        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return q1.poll();
    }

    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return q1.peek();
    }

    public static void main(String[] args) {

        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
    }
}
