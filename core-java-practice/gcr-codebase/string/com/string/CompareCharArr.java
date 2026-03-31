package com.string;
import java.util.Scanner;

public class CompareCharArr {
//    function to get characters of a string
    public static char[] getChars(String str) {

        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }

        return chars;
    }
//    function to compare characters array
    public static boolean compStr(char[] arrChar1, char[] arrChar2) {

        if (arrChar1.length != arrChar2.length) {
            return false;
        }
        for (int i = 0; i < arrChar1.length; i++) {
            if (arrChar1[i] != arrChar2[i]) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for text
        System.out.print("Enter a string: ");
        String text = sc.next();
//        function call and display output
        char[] array1 = getChars(text);
        char[] array2 = text.toCharArray();
        boolean result = compStr(array1, array2);
        System.out.println("\nArrays match: " + result);
    }
}

