package com.controlflow;
import java.util.Scanner;

public class CalcFactorial {

    // Function to compute factorial using while loop
    public static long factorial(int number) {
        long result = 1;
        int i = 1;

        while (i <= number) {
            result *= i;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
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
