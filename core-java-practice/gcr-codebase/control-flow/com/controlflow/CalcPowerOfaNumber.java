package com.controlflow;
import java.util.Scanner;

public class CalcPowerOfaNumber {

    // function to calculate power
    public static long calculatePower(int number, int power) {

        long result = 1;

        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        return result;
    }

    public static void main(String[] args) {
//        create Scanner object
        Scanner sc = new Scanner(System.in);

        // get input value for number and power
        System.out.print("Enter the base number: ");
        int number = sc.nextInt();
        System.out.print("Enter the power (positive integer): ");
        int power = sc.nextInt();

        // function call and calculate power of a number and display output
        if (number > 0 && power >= 0) {
            long result = calculatePower(number, power);
            System.out.println(number + " raised to the power " + power + " is: " + result);
        } else {
            System.out.println("Please enter positive integers (power can be zero).");
        }

        sc.close();
    }
}

