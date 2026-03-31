package com.string;
import java.util.Scanner;

public class WordReplace {
//    method to replace a word in a sentence
    public static String replaceWord(String sentence, String oldWord, String newWord) {

        String[] words = sentence.split(" ");
        String result = "";

        for (String word : words) {
            if (word.equals(oldWord)) {
                result += newWord + " ";
            } else {
                result += word + " ";
            }
        }
        return result.trim();
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input values
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        System.out.print("Enter word to replace: ");
        String oldWord = sc.next();
        System.out.print("Enter new word: ");
        String newWord = sc.next();
        String output = replaceWord(sentence, oldWord, newWord);
        System.out.println("Modified Sentence: " + output);

    }
}

