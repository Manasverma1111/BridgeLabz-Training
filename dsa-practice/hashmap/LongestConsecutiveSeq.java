package hashmap;

import java.util.HashSet;

public class LongestConsecutiveSeq {
    public static int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 1, 2, 3, 4, 6, 9};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }
}
