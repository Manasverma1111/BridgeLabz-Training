import java.util.Scanner;

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {

        if (n > 0 && ((n & (n - 1)) == 0)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check if power of two: ");

        int num = sc.nextInt();
        boolean res = isPowerOfTwo(num);
        System.out.println(res);
    }
}
