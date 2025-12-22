package com.string;
import java.util.Scanner;

public class FreqOfUniqueChars{
//    function to find unique characters
    public static char[] uniqChar(String str){

        char[] temp = new char[str.length()];
        int ind = 0;
        for(int i = 0;i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean isUnique = true;

            for(int j = 0;j < i; j++) {
                if(ch == str.charAt(j)){
                    isUnique = false;
                    break;
                }
            }

            if(isUnique) {
                temp[ind++] = ch;
            }
        }

        char[] arr = new char[ind];
        for(int i = 0;i < ind; i++){
            arr[i] = temp[i];
        }

        return arr;
    }
    public static String[][] freqUniq(String str) {

        int[] freq = new int[256];
        for(int i = 0;i < str.length(); i++){
            freq[str.charAt(i)]++;
        }
        char[] uniqueChars = uniqChar(str);
        String[][] res = new String[uniqueChars.length][2];

        for(int i = 0; i < uniqueChars.length; i++) {
            res[i][0] = String.valueOf(uniqueChars[i]);
            res[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return res;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for text
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[][] arr = freqUniq(text);
        System.out.println("Character\tFrequency");

        for (String[] str:arr) {
            System.out.println(str[0] + "\t" + str[1]);
        }

        sc.close();
    }
}

