package com.string;
import java.util.Scanner;

public class LexicographicString {
//    method to compare two strings lexicographically
    public static int compareStrings(String s1, String s2) {

        int length = Math.min(s1.length(), s2.length());

        for (int i = 0; i < length; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (ch1 != ch2) {
                return ch1 - ch2;
            }
        }

        return s1.length() - s2.length();
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int result = compareStrings(s1, s2);

        if (result < 0) {
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
        } else if (result > 0) {
            System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }

    }
}

