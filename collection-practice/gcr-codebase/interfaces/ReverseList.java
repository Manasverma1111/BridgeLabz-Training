package interfaces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    public static void reverseList(List list) {

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            Object temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        List arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        List linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        reverseList(arrayList);
        reverseList(linkedList);

        System.out.println("Reversed ArrayList : " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
