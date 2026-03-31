package com.controlflow;
import java.util.Scanner;

public class FactorsOfaNumber {

    // function to check if number is a positive integer
    public static boolean isPositiveInteger(int number) {
        return number > 0;
    }

    // function to print factors of the number
    public static void printFactors(int number) {
        System.out.println("Factors of " + number + " are:");
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // get input value for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // check and display output
        if (isPositiveInteger(number)) {
            printFactors(number);
        } else {
            System.out.println("Please enter a positive integer.");
        }

        sc.close();
    }
}

