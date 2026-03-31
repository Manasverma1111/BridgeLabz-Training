package Junit.src.main.java.org.example;

public class StringUtils {

    public static String reverseString(String str) {

        if (str == null) {
            return null;
        }

        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {

        if (str == null) {
            return false;
        }

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String toUppercase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }
}
