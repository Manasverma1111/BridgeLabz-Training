package com.controlflow;

import java.util.Scanner;

public class FizzBuzzUsingWhileLoop {

    // Function to check if number is a positive integer
    static boolean isPositiveInteger(int number) {
        return number > 0;
    }

    // Function to print FizzBuzz using while loop
    public static void printFizzBuzz(int number) {
        int i = 1;

        while (i <= number) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // get input for value number
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // check and display Output
        if (isPositiveInteger(number)) {
            printFizzBuzz(number);
        } else {
            System.out.println("Please enter a positive integer.");
        }

        sc.close();
    }
}

