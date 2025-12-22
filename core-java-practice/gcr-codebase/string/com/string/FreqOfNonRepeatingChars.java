package com.string;
import java.util.Scanner;

public class FreqOfNonRepeatingChars {
//    function to find first non-repeating character
    public static char findFirstNonRepeatCh(String str) {

        int[] freqArr = new int[256];
        // count frequency
        for(int i = 0; i < str.length(); i++) {
            freqArr[str.charAt(i)]++;
        }
        // find first non-repeating character
        for(int i = 0;i < str.length(); i++){
            if(freqArr[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }

        return '0';
    }

    //Main method
    public static void main(String[] args) {
//        create scanner object
        Scanner sc=new Scanner(System.in);
//        get input value for string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        char res = findFirstNonRepeatCh(str);

        if(res != '0') {
            System.out.println("First non-repeating character is: " + res);
        } else {
            System.out.println("No non-repeating character found");
        }
    }
}
