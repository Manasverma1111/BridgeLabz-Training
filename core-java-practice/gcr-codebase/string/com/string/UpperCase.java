package com.string;
import java.util.Scanner;

public class UpperCase {
//    function to convert string to uppercase
    public static String toUpperc(String str) {

        String s = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                s += (char)(ch - 32);
            else
                s += ch;
        }
        return s;

    }
//    function to compare both the strings
    public static boolean cmp(String s1, String s2) {

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
//        get input values for two strings
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String s1 = toUpperc(str);
        String s2 = str.toUpperCase();
//        function call and display output
        System.out.println("Does both strings match? " + cmp(s1, s2));
    }
}

