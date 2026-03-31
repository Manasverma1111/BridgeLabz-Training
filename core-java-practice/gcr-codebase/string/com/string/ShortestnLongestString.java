package com.string;
import java.util.Scanner;

public class ShortestnLongestString {

    // method to find string length without using length()
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

        // count words
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

    // method to create 2D array of word and its length
    public static String[][] wordsWithLength(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    // method to find shortest and longest word indexes
    // returns {shortestIndex, longestIndex}
    public static int[] findShortestnLongest(String[][] wordLengthTable) {

        int shortestIndex = 0;
        int longestIndex = 0;

        int shortestLength = Integer.parseInt(wordLengthTable[0][1]);
        int longestLength = Integer.parseInt(wordLengthTable[0][1]);

        for (int i = 1; i < wordLengthTable.length; i++) {
            int currentLength = Integer.parseInt(wordLengthTable[i][1]);

            if (currentLength < shortestLength) {
                shortestLength = currentLength;
                shortestIndex = i;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestIndex = i;
            }
        }

        return new int[] { shortestIndex, longestIndex };
    }

    // Main method
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input string value
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // split words
        String[] words = customSplit(input);
        // create 2D array of words and it's length
        String[][] wordLengthTable = wordsWithLength(words);
        // find shortest and longest words
        int[] resultIndexes = findShortestnLongest(wordLengthTable);

        // display output
        System.out.println("Longest Word: " + wordLengthTable[resultIndexes[1]][0] + " (Length: "
                + Integer.parseInt(wordLengthTable[resultIndexes[1]][1]) + ")");
        System.out.println("Shortest Word: " + wordLengthTable[resultIndexes[0]][0]
                + " (Length: " + Integer.parseInt(wordLengthTable[resultIndexes[0]][1]) + ")");

        sc.close();
    }
}

