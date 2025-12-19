package com.controlflow;

import java.util.Scanner;

public class CalcSumOfNaturalNum {

    // function to check if number is a natural number
    public static boolean isNaturalNumber(int n) {
        return n > 0;
    }

    // function to compute sum using while loop
    public static int sumUsingWhile(int n) {
        int sum = 0;
        int i = 1;

        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }

    // function to compute sum using formula
    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // get input value for number n
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // function call and display output
        if (isNaturalNumber(n)) {

            int whileSum = sumUsingWhile(n);
            int formulaSum = sumUsingFormula(n);

            System.out.println("Sum using while loop: " + whileSum);
            System.out.println("Sum using formula: " + formulaSum);

            if (whileSum == formulaSum) {
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

