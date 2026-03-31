package hashmap;
import java.util.*;

public class SubarraySumZero {

    static void printZeroSumSubarrays(int[] arr) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    for (int idx = start + 1; idx <= i; idx++) {
                        System.out.print(idx + " ");
                    }
                    System.out.println();
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, -7, 1, 3, 3, 1, -4};
        printZeroSumSubarrays(arr);
    }
}
