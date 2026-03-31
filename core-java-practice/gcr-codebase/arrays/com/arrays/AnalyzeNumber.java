package com.arrays;
import java.util.Scanner;

public class AnalyzeNumber {

    // function to check number type
    public static void checkNumType(int num) {

        if (num > 0) {
            if (num % 2 == 0) {
                System.out.println(num + " is Positive and Even");
            } else {
                System.out.println(num + " is Positive and Odd");
            }
        } else if (num < 0) {
            System.out.println(num + " is Negative");
        } else {
            System.out.println(num + " is Zero");
        }
    }

    // function to compare first and last elements
    public static void compareFirstAndLast(int first, int last) {

        if (first == last) {
            System.out.println("First and last elements are equal.");
        } else if (first > last) {
            System.out.println("First element is greater than the last element.");
        } else {
            System.out.println("First element is less than the last element.");
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        // get five input values
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println();
        for (int i = 0; i < numbers.length; i++) {
            checkNumType(numbers[i]);
        }

        // function call and compare first and last elements
        System.out.println();
        compareFirstAndLast(numbers[0], numbers[numbers.length - 1]);

        sc.close();
    }
}

