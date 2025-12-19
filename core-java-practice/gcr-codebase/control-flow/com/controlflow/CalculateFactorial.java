package com.controlflow;
import java.util.Scanner;

public class CalculateFactorial {

    // Function to compute factorial using for loop
    static long factorial(int number) {
        long result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
//        create Scanner object
        Scanner sc = new Scanner(System.in);

        // get input for value number
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        // calculate and display Output
        if (number > 0) {
            long fact = factorial(number);
            System.out.println("Factorial of " + number + " is " + fact);
        } else {
            System.out.println("Please enter a positive integer.");
        }

        sc.close();
    }
}

