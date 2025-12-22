package com.string;
import java.util.Scanner;

public class UniqueCharacter {

    // function to find length of text without using length()
    public static int findLength(String text) {

        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    // function to find unique characters
    public static char[] findUniqueChars(String text) {

        int length = findLength(text);
        char[] temp = new char[length];
        int index = 0;

        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[index++] = current;
            }
        }

        // create final array with exact size
        char[] uniqueChars = new char[index];
        for (int i = 0; i < index; i++) {
            uniqueChars[i] = temp[i];
        }

        return uniqueChars;
    }

    // Main method
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input for text
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        char[] uniqueCharacters = findUniqueChars(text);

        System.out.print("Unique characters are: ");
        for (char ch : uniqueCharacters) {
            System.out.print(ch + " ");
        }

        sc.close();
    }
}

