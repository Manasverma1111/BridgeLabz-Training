package com.string;
import java.util.Scanner;

public class ReverseString {
//    method to reverse a string
    public static String reverseString(String str) {

        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String result = reverseString(str);
        System.out.println("Reversed string: " + result);
    }
}

