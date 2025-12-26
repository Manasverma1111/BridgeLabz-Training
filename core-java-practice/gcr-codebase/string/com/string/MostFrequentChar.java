package com.string;
import java.util.Scanner;

public class MostFrequentChar {
//    method to find most frequent character
    public static char findMostFrequentChar(String str) {

        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        int maxCount = 0;
        char result = ' ';

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] > maxCount) {
                maxCount = freq[str.charAt(i)];
                result = str.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        char mostFrequent = findMostFrequentChar(str);
        System.out.println("Most Frequent Character: '" + mostFrequent + "'");

    }
}

