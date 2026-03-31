package interfaces;

import java.util.*;

public class RotateListByK {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int k = 2;
        List<Integer> rotatedList = new ArrayList<>();

        for (int i = k; i < list.size(); i++) {
            rotatedList.add(list.get(i));
        }

        for (int i = 0; i < k; i++) {
            rotatedList.add(list.get(i));
        }

        System.out.println(rotatedList);

    }
}
