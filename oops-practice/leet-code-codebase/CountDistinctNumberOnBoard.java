public class CountDistinctNumberOnBoard {

    public static int distinctIntegers(int n) {

        return Math.max(n - 1, 1);
    }

    public static void main(String[] args) {

        int n = 3;
        System.out.println(distinctIntegers(n));
    }
}
