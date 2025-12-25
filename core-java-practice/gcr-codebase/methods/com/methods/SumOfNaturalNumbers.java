package com.methods;
import java.util.Scanner;

public class SumOfNaturalNumbers {
//    recursive method to find sum of n natural numbers
    public static int recursiveSum(int n) {

        if (n == 0) {
            return 0;
        }
        return n + recursiveSum(n - 1);
    }
//    method to find sum using formula n*(n+1)/2
    public static int formulaSum(int n) {

        return n * (n + 1) / 2;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
//        get input value for a number
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input! Please enter a natural number.");
            return;
        }
//        function call and display output
        int sumByRecursion = recursiveSum(n);
        int sumByFormula = formulaSum(n);

        System.out.println("Sum using recursion: " + sumByRecursion);
        System.out.println("Sum using formula: " + sumByFormula);

        if (sumByRecursion == sumByFormula) {
            System.out.println("Result is correct.");
        } else {
            System.out.println("Result is incorrect.");
        }

    }
}
