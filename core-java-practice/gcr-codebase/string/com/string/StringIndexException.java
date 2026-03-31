package com.string;
import java.util.Scanner;

public class StringIndexException {
//    function to generate exception
    public static void genEx(String text, int index) {

        char ch = text.charAt(index);
    }
//    function to handle exception
    public static void handleEx(String text, int index) {

        try {
            char ch = text.charAt(index);
            System.out.println("Character at index " + index + ": " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Invalid index " + index);
        }
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input for text
        System.out.print("Enter a text: ");
        String text = sc.next();
//        get input for index
        System.out.print("Enter index: ");
        int index = sc.nextInt();
//        function call and display output
        try {
            genEx(text, index);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Index " + index + " out of bounds");
        }

        handleEx(text, index);
    }
}

