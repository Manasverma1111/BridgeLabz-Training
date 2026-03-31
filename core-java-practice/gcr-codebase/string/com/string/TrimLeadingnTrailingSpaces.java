package com.string;
import java.util.Scanner;

public class TrimLeadingnTrailingSpaces {

    // method to find start and end indexes after trimming spaces
    // returns int array: {startIndex, endIndex}
    public static int[] findTrimIndexes(String text) {

        int start = 0;
        int end = 0;
        try {
            while (true) {
                text.charAt(end);
                end++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            end = end - 1;
        }

        // trim leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        // trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        return new int[] { start, end };
    }

    // method to create substring using charAt()
    public static String createSubstring(String text, int start, int end) {

        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }

        return result;
    }

    // method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {

        int i = 0;
        try {
            while (true) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return false;
                }
                i++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // check if both strings ended at same time
            try {
                s1.charAt(i);
                return false;
            } catch (StringIndexOutOfBoundsException ex) {
                try {
                    s2.charAt(i);
                    return false;
                } catch (StringIndexOutOfBoundsException ex2) {
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input string
        System.out.print("Enter a string with leading and trailing spaces: ");
        String input = sc.nextLine();

//        function call
        int[] indexes = findTrimIndexes(input);
        String customTrimmed = createSubstring(input, indexes[0], indexes[1]);
        // built-in trim
        String builtInTrimmed = input.trim();
        // compare results
        boolean isSame = compareStrings(customTrimmed, builtInTrimmed);

        // display output
        System.out.println("Custom Result: "  + customTrimmed);
        System.out.println("Built-in Result: " + builtInTrimmed);
        System.out.println("Do both results match? " + isSame);

        sc.close();
    }
}
