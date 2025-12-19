package com.controlflow;

import java.util.Scanner;

public class CheckLargestNumber {
    public static void main(String[] args) {

        //create a scanner object
        Scanner sc = new Scanner(System.in);

        // get three input values for the three numbers
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();
        System.out.print("Enter third number: ");
        int number3 = sc.nextInt();

        // function calls and displays output
        System.out.println("Is the first number the largest? " + isLargest(number1, number2, number3));
        System.out.println("Is the second number the largest? " + isLargest(number2, number1, number3));
        System.out.println("Is the third number the largest? " + isLargest(number3, number1, number2));

        sc.close();
    }

    // function to check if a number is the largest
    static boolean isLargest(int currentNum, int otherNum1, int otherNum2) {
        return currentNum > otherNum1 && currentNum > otherNum2;
    }
}
