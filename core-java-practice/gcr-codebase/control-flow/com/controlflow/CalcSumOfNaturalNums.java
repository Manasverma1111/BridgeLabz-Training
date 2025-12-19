package com.controlflow;

import java.util.Scanner;

public class CalcSumOfNaturalNums {

    // function to check if number is a natural number
    public static boolean isNaturalNumber(int n) {
        return n > 0;
    }

    // function to compute sum using for loop
    public static int sumUsingFor(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // function to compute sum using formula
    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // function call, Check and display output
        if (isNaturalNumber(n)) {

            int forSum = sumUsingFor(n);
            int formulaSum = sumUsingFormula(n);

            System.out.println("Sum using for loop: " + forSum);
            System.out.println("Sum using formula: " + formulaSum);

            if (forSum == formulaSum) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("The computations do not match.");
            }

        } else {
            System.out.println("The number is not a natural number.");
        }

        sc.close();
    }
}

