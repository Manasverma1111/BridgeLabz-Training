package com.string;
import java.util.Scanner;

public class TypeOfaCharacter {

    // method to check whether a character is Vowel, Consonant, or Not a Letter
    public static String checkCharacter(char ch) {

        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // check if character is a letter
        if (ch >= 'a' && ch <= 'z') {

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // method to find character type
    public static String[][] analyzeString(String text) {

        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // end of string
        }
        String[][] result = new String[length][2];

        for (int i = 0; i < length; i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkCharacter(text.charAt(i));
        }

        return result;
    }

    // method to display 2D array in tabular format
    public static void displayTable(String[][] data) {

        System.out.println();
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        // analyze string
        String[][] result = analyzeString(input);

        // display output
        displayTable(result);

        sc.close();
    }
}

