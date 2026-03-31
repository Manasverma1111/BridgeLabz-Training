package com.string;
import java.util.Scanner;

public class FreqOfEachChar {

    // function to ind the frequency of characters in the string
    public static String[][] findFreq(String str) {

        int[] freq = new int[256];

        // count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        // store characters and its frequency in a 2D array
        String[][] result = new String[str.length()][2];
        int index = 0;

        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = String.valueOf((char) i);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for string
        System.out.print("Enter text: ");
        String str = sc.nextLine();

//        function call and display output
        String[][] freqArray = findFreq(str);
        System.out.println("Character\tFrequency");

        for (String[] row : freqArray) {
            if (row[0] != null) {
                System.out.println(row[0] + "\t" + row[1]);
            }
        }

        sc.close();
    }
}

