package hashmap;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = k - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;

        int[] result = twoSum(nums, target);

        if (result.length == 2) {
            System.out.println(result[0] + ", " + result[1]);
        } else {
            System.out.println("not found");
        }
    }
}

