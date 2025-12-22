package com.string;
import java.util.Scanner;

public class ExceptionInArray {
//    function to generate exception
    public static void genEx(String[] arrStr) {
//        display the output
        System.out.println(arrStr[arrStr.length]);
    }
//    function to handle exception
    public static void handleEx(String[] arrStr) {

        try {
            System.out.println(arrStr[arrStr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
        }
    }
    public static void main(String[] args) {
//      create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for n
        System.out.print("Enter the number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the strings: ");
        String[] arrStr = new String[n];

        for (int i = 0; i < n; i++) {
            arrStr[i] = sc.nextLine();
        }
//            function calling
        genEx(arrStr);
        handleEx(arrStr);
    }
}

