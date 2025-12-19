package com.controlflow;
import java.util.Scanner;

public class OddEvenNumbers {

    // Function to check if a number is natural
    public static boolean isNaturalNumber(int n) {
        return n > 0;
    }

    // Function to print odd and even numbers
    public static void printOddEven(int number) {
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is even");
            } else {
                System.out.println(i + " is odd");
            }
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input value for number
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        // check and display output
        if (isNaturalNumber(number)) {
            printOddEven(number);
        } else {
            System.out.println("Please enter a valid natural number.");
        }

        sc.close();
    }
}

