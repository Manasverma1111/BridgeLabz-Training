package hashmap;

import java.util.HashMap;
import java.util.Map;

public class PairsInArray {

    public static boolean findPairs(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = k - nums[i];
            if (map.containsKey(diff)) {
                return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int k = 19;
        boolean res = findPairs(nums, k);
        System.out.println(res);
    }
}
