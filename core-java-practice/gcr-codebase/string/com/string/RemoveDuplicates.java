package com.string;
import java.util.Scanner;

public class RemoveDuplicates {
//    method to remove duplicate characters
    public static String removeDuplicates(String str) {

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (result.indexOf(currentChar) == -1) {
                result += currentChar;
            }
        }

        return result;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String output = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + output);

    }
}

