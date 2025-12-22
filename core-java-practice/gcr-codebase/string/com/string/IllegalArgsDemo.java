package com.string;
import java.util.Scanner;

public class IllegalArgsDemo {
//    function to generate exception
    static void genEx(String str) {

        str.substring(5, 2);
    }
//    function to handle exception
    public static void handleEx(String str) {

        try {
            str.substring(5, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value
        String input = sc.nextLine();
//        function call and display output
        genEx(input);
        handleEx(input);
    }
}

