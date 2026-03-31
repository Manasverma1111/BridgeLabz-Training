package com.string;
import java.util.Scanner;

public class SplitTextWithLen {

    // method to find length of a string without using length()
    public static int findLength(String str) {

        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    // method to split text into words without using split()
    public static String[] customSplit(String text) {

        int length = findLength(text);
        int wordCount = 1;

        // count number of words
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // store space indexes
        int[] spaceIndexes = new int[wordCount + 1];
        spaceIndexes[0] = -1;
        int index = 1;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[index] = length;

        // extract words
        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            String word = "";
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }

        return words;
    }

    // method to create a 2D array of word and its length
    public static String[][] wordsWithLength(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input string for input
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // function call and split the words
        String[] words = customSplit(input);

        // create a 2D array of words and length
        String[][] wordLengthTable = wordsWithLength(words);

        // display output in tabular format
        System.out.println("\nWord\tLength");
        System.out.println();

        for (int i = 0; i < wordLengthTable.length; i++) {
            int length = Integer.parseInt(wordLengthTable[i][1]);
            System.out.println(wordLengthTable[i][0] + "  " + length);
        }

        sc.close();
    }
}
