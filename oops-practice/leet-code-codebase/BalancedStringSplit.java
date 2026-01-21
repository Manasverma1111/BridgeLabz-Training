public class BalancedStringSplit {
    public static int balancedStringSplit(String s) {
        int count = 0;
        int balance = 0;

        for (char ch: s.toCharArray()) {
            if (ch == 'R') {
                balance++;
            } else if (ch == 'L') {
                balance--;
            }

            if (balance == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String str = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(str));
    }
}
