package interfaces;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class FindNthElement {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));

        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();

        int n = 2; // Find the 2nd element from the end
        for (int i = 0; i < n; i++) {
            if (fast.hasNext()) {
                fast.next();
            } else {
                System.out.println("List has fewer than " + n + " elements.");
                return;
            }
        }

        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }
        System.out.println(slow.next());
    }
}
