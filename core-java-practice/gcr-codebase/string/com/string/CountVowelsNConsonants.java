package com.string;
import java.util.Scanner;

public class CountVowelsNConsonants {
//    method to count vowels
    public static int countVowels(String str) {

        int vowelCount = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }
        return vowelCount;
    }
//    method to count consonants
    public static int countConsonants(String str) {

        int consonantCount = 0;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z' &&
                    ch != 'a' && ch != 'e' && ch != 'i' &&
                    ch != 'o' && ch != 'u') {
                consonantCount++;
            }
        }
        return consonantCount;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        gte input value for a string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int vowels = countVowels(str);
        int consonants = countConsonants(str);
        System.out.println("Vowels count: " + vowels);
        System.out.println("Consonants count: " + consonants);

    }
}

