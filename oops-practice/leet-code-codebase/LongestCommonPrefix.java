import java.util.Arrays;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        int n = strs.length;
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[n - 1];
        int minLen = Math.min(first.length(), last.length());

        for (int i = 0; i < minLen; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return sb.toString();
            }

            sb.append(first.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flat"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }
}
