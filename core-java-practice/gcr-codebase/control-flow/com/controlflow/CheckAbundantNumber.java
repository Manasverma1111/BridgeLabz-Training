package com.controlflow;
import java.util.Scanner;

public class CheckAbundantNumber {

    // function to check if a number is Abundant
    public static boolean isAbundant(int number) {

        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i; // add divisor to sum
            }
        }

        // check if sum of divisors is greater than the number
        return sum > number;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input value for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

//        function call and check for Abundant number and display output
        if (number > 0) {
            if (isAbundant(number)) {
                System.out.println(number + " is an Abundant Number.");
            } else {
                System.out.println(number + " is not an Abundant Number.");
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }

        sc.close();
    }
}

