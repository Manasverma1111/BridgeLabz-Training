package com.string;
import java.util.Scanner;

public class CountVowelsConsonants {

    // method to check whether a character is vowel, consonant, or not a letter
    // returns: "Vowel", "Consonant", or "Not a Letter"
    public static String checkCharacter(char ch) {

        // convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // check if character is a lowercase alphabet
        if (ch >= 'a' && ch <= 'z') {

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // method to find vowels and consonants using charAt()
    // returns int array: {vowelCount, consonantCount}
    public static int[] findVowelsAndConsonants(String text) {

        int vowelCount = 0;
        int consonantCount = 0;
        int index = 0;

        try {
            // iterate string using charAt() and exception handling
            while (true) {
                char ch = text.charAt(index);
                String result = checkCharacter(ch);

                if (result.equals("Vowel")) {
                    vowelCount++;
                } else if (result.equals("Consonant")) {
                    consonantCount++;
                }

                index++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }

        return new int[] { vowelCount, consonantCount };
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input for string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        // function call user-defined method
        int[] counts = findVowelsAndConsonants(input);

        // display output
        System.out.println("\nVowel Count: " + counts[0]);
        System.out.println("Consonant Count: " + counts[1]);

        sc.close();
    }
}
