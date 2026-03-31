package com.string;
import java.util.Scanner;

public class SplitText {

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

        // count words
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // store space indexes
        int[] spaceIndexes = new int[wordCount + 1];
        int index = 1;
        spaceIndexes[0] = -1;

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

    // method to compare two String arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input string for input
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // function call and user-defined split
        String[] customResult = customSplit(input);

        // using built-in split
        String[] builtInResult = input.split(" ");

        // display custom split output
        System.out.println("\nCustom split result:");
        for (String word : customResult) {
            System.out.println(word);
        }

        // display built-in split output
        System.out.println("\nBuilt-in split() result:");
        for (String word : builtInResult) {
            System.out.println(word);
        }

        // compare both output
        boolean isSame = compareArrays(customResult, builtInResult);
        System.out.println("\nDo both split results match? " + isSame);

        sc.close();
    }
}
