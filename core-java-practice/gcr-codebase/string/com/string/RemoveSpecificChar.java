package com.string;
import java.util.Scanner;

public class RemoveSpecificChar {
//    method to remove a specific character
    public static String removeCharacter(String str, char ch) {

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                result += str.charAt(i);
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

        System.out.print("Enter character to remove: ");
        char ch = sc.next().charAt(0);
        String resStr = removeCharacter(str, ch);
        System.out.println("Modified String: \"" + resStr + "\"");

    }
}

