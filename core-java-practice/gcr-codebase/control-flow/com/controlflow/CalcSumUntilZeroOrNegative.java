package com.controlflow;

import java.util.Scanner;

public class CalcSumUntilZeroOrNegative {
    public static void main(String[] args) {

//        function call
        double result = calculateSum();
        // Output
        System.out.println("The total sum is " + result);

    }

    static double calculateSum() {
        Scanner sc = new Scanner(System.in);

        double total = 0.0;

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double value = sc.nextDouble();

            // Break condition
            if (value <= 0) {
                break;
            }

            total += value;
        }

        return total;
    }
}
