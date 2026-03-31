package com.string;
import java.util.Scanner;

public class LowerCase {
//    function to convert string to lowercase
    static String toLowercase(String str) {
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                s += (char)(ch + 32);
            else
                s += ch;
        }
        return s;
    }
//    function to compare both the strings
    static boolean cmp(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input for string
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        String s1 = toLowercase(s);
        String s2 = s.toLowerCase();
        System.out.println("Does both the string math? " + cmp(s1, s2));
    }
}

