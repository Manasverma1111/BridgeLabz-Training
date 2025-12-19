package com.controlflow;
import java.util.Scanner;

import java.util.Scanner;

public class FactorsOfaNum {

    // function to check if number is positive
    public static boolean isPositiveInteger(int number) {
        return number > 0;
    }

    // function to print factors using while loop
    public static void printFactors(int number) {
        System.out.println("Factors of " + number + " are:");
        int counter = 1;

        while (counter < number) {
            if (number % counter == 0) {
                System.out.println(counter);
            }
            counter++;
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
