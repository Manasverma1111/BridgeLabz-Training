package com.controlflow;

import java.util.Scanner;

public class CheckNumberType {
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input for a number
        System.out.print("Enter a number to check it's type: ");
        int number = sc.nextInt();

//        function call and display output
        System.out.println(checkNumType(number));


    }
//function to check the type of a number
    public static String checkNumType(int number) {

        if (number > 0) {
            return "positive";
        } else if (number < 0) {
            return "negative";
        } else {
            return "zero";
        }
    }
}
