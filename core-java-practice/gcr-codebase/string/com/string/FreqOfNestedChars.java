package com.string;
import java.util.Scanner;

public class FreqOfNestedChars{
//    function to find frequency of characters
    public static String[] findFreq(String str){

        char[] curr = str.toCharArray();
        int[] freq = new int[curr.length];

        for(int i = 0;i < curr.length; i++){
            if(curr[i] == '0') continue;
            freq[i] = 1;
            for(int j = i + 1;j < curr.length; j++){
                if (curr[i] == curr[j]){
                    freq[i]++;
                    curr[j] = '0';
                }
            }
        }

        String[] res = new String[curr.length];
        int ind = 0;

        for(int i = 0;i < curr.length; i++){
            if(curr[i] != '0'){
                res[ind++] = curr[i] + ":" + freq[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input for string
        String str = sc.nextLine();
        String[] out = findFreq(str);

        for(String s:out){
            if(s != null) System.out.println(s);
        }
    }
}
