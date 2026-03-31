package com.string;
import java.util.Scanner;

public class CompareString {
//    function to compare strings
    public static boolean compStrs(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input for first string
        System.out.print("Enter first string: ");
        String str1 = sc.next();
//        get input for second string
        System.out.print("Enter second string: ");
        String str2 = sc.next();
//        function call and display output
        boolean customResult = compStrs(str1, str2);
        boolean builtInResult = str1.equals(str2);

        System.out.println("Custom method (charAt) result: " + customResult);
        System.out.println("Built-in equals() result: " + builtInResult);
        System.out.println("Does both strings match? " + (customResult == builtInResult));
    }
}

