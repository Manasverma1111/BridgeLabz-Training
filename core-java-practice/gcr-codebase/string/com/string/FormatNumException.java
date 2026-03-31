package com.string;
import java.util.Scanner;

public class FormatNumException {
//    function to generate exception
    public static void genEx(String str) {
        Integer.parseInt(str);
    }
//    function to handle exception
    public static void handleEx(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
        }
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input for string
        System.out.print("Enter a string: ");
        String t = sc.nextLine();
//        function calling
        genEx(t);
        handleEx(t);
    }
}


