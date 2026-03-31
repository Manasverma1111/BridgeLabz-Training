import java.util.Scanner;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {

        // negative numbers or numbers ending with 0 (except 0 itself)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        get input value for a number
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        boolean res = isPalindrome(num);
        System.out.println("The number is palindrome: " + res);
    }
}

