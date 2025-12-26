package com.string;
import java.util.Scanner;

public class LongestWord {
//    method to find the longest word in a sentence
    public static String findLongestWord(String sentence) {

        String[] words = sentence.split(" ");
        String longestWord = words[0];

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        String result = findLongestWord(sentence);
        System.out.println("Longest word in the sentence: " + result);

    }
}

