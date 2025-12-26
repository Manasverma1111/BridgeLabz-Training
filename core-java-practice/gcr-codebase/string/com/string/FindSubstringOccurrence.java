package com.string;
import java.util.Scanner;

public class FindSubstringOccurrence {
//    method to count substring occurrences
    public static int countOccurrences(String str, String sub) {

        int count = 0;
        int index = 0;

        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index = index + sub.length();
        }
        return count;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String str = sc.nextLine();
        System.out.print("Enter the substring: ");
        String sub = sc.nextLine();
        int result = countOccurrences(str, sub);
        System.out.println("Substring occurs " + result + " times.");

    }
}

