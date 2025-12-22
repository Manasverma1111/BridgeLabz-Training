package com.string;
import java.util.Scanner;

public class CompareSubstring {
//    function to get substring
    public static String getSub(String s, int a, int b) {
        String r = "";
        for (int i = a; i < b; i++) {
            r += s.charAt(i);
        }
        return r;
    }
//    function to compare the strings
    public static boolean compStr(String s1, String s2) {

        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input for text
        System.out.print("Enter a text: ");
        String text = sc.next();
        int startIndex = sc.nextInt();
        int endIndex = sc.nextInt();
        String s1 = getSub(text, startIndex, endIndex);
        String s2 = text.substring(startIndex, endIndex);
//        function call and display output
        boolean res = compStr(s1, s2);
        System.out.println("Custom substring: " + s1);
        System.out.println("Built-in substring: " + s2);
        System.out.println("Substrings match: " + res);
    }
}
