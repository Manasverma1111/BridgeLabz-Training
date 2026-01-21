package interfaces;

import java.util.*;

public class RemoveDuplicatesList {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> res = new ArrayList<>();

        for (Integer num : list) {
            if (!res.contains(num)) {
                res.add(num);
            }
        }

        System.out.println(res);

    }
}
