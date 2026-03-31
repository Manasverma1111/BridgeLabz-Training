package com.string;
import java.util.Scanner;

public class ToggleCase {
//    method to toggle case of characters
    public static String toggleCase(String str) {

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isUpperCase(ch)) {
                result += Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                result += Character.toUpperCase(ch);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for a string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String output = toggleCase(str);
        System.out.println("Toggled string: " + output);

    }
}

