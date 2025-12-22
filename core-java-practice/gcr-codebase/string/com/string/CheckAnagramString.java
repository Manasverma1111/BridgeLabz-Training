package com.string;
import java.util.*;
public class CheckAnagramString {
//    function to check if a string is anagram or not
    public static boolean isAnagram(String s1, String s2) {

        if(s1.length()!=s2.length()) return false;
        int[] freq1=new int[256];
        int[] freq2=new int[256];

        for(int i=0;i<s1.length();i++){
            freq1[s1.charAt(i)]++;
            freq2[s2.charAt(i)]++;
        }

        for(int i=0;i<256;i++){
            if(freq1[i]!=freq2[i])return false;
        }
        return true;
    }
    public static void main(String args[]){
//        create scanner object
        Scanner sc=new Scanner(System.in);
//        get input for first string
        System.out.print("Enter first string: ");
        String str1=sc.nextLine();
//        get input for second string
        System.out.print("Enter second string: ");
        String str2=sc.nextLine();
//        function call and display output
        if(isAnagram(str1,str2)){
            System.out.println("Is Anagram");
        }else{
            System.out.println("Is Anagram");
        }
    }
}

