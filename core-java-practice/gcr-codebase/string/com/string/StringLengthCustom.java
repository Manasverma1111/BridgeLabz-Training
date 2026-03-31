package com.string;
import java.util.Scanner;

public class StringLengthCustom {
//    custom function to find length of a string
    public static int findLength(String str) {

        int count = 0;

        try {
            // infinite loop to access characters until exception occurs
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // exception indicates end of string
            return count;
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input values for number
        System.out.print("Enter a string: ");
        String input = sc.next();

        // calling user-defined method
        int customLength = findLength(input);

        // calling built-in length() method
        int builtInLength = input.length();

        // displaying output
        System.out.println("Length using user-defined method: " + customLength);
        System.out.println("Length using built-in length() method: " + builtInLength);

        sc.close();
    }
}

