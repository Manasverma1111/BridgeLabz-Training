package com.string;
import java.util.*;
public class PalindromeStr {
//    function to check if a string is palindrome or not
    static boolean isPalindrome(String str) {

        int start=0;
        int end=str.length()-1 ;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[]args){
//        create scanner object
        Scanner sc=new Scanner(System.in);
//        get input value for string
        String str = sc.nextLine();

//        function call and display output
        if(isPalindrome(str)){
            System.out.println("Is Palindrome");
        }else{
            System.out.println("Is Not Palindrome");
        }
    }
}

