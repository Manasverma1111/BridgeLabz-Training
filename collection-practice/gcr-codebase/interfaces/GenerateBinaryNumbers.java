package interfaces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateBinaryNumbers {

    public static List<String> generateBinary(int n) {

        List<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            list.add(current);

            queue.add(current + "0");
            queue.add(current + "1");
        }

        return list;
    }

    public static void main(String[] args) {

        int n = 10;

        List<String> resList = generateBinary(n);
        System.out.println(resList);
    }
}
