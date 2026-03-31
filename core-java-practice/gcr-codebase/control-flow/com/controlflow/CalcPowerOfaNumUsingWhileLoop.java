package com.controlflow;
import java.util.Scanner;

public class CalcPowerOfaNumUsingWhileLoop {

    // function to calculate power of number using while loop
    public static long calculatePower(int number, int power) {

        long result = 1;
        int counter = 0;

        while (counter < power) {
            result *= number;
            counter++;
        }

        return result;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input value for number and power
        System.out.print("Enter the base number: ");
        int number = sc.nextInt();
        System.out.print("Enter the power positive/zero: ");
        int power = sc.nextInt();

        // function call and compute power, display output
        if (power >= 0) {
            long result = calculatePower(number, power);
            System.out.println(number + " raised to the power " + power + " is: " + result);
        } else {
            System.out.println("Please enter a positive integer/zero for the power.");
        }

        sc.close();
    }
}

