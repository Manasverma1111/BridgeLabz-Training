package com.controlflow;

import java.util.Scanner;

public class CalcSumUntilZero {
    public static void main(String[] args) {

        double result = calculateSum();
        // output the result
        System.out.println("The total sum is " + result);
    }

    public static double calculateSum() {
//create scanner object
        Scanner sc = new Scanner(System.in);

        double total = 0.0;
        double value;

//        get input value, press 0 to exit
        System.out.print("Enter a number (press 0 to stop): ");
        value = sc.nextDouble();

        while (value != 0) {
            total += value;

            System.out.print("Enter a number (0 to stop): ");
            value = sc.nextDouble();
        }

        return total;
    }
}
