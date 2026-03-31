package com.methods;
import java.util.Scanner;

public class FactorsOfANumber {
//    function to find factors of a number
    public static int[] findFactors(int number) {

        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];

        int ind = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[ind++] = i;
            }
        }

        return factors;
    }
//    function to calculate sum of factors
    public static int sumOfFactors(int[] factors) {

        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }
//    function to calculate product of factors
    public static long productOfFactors(int[] factors) {

        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }
//    function to calculate sum of squares of factors
    public static double sumOfSquares(int[] factors) {
        double sum = 0;
        for (int factor : factors) {
            sum += Math.pow(factor, 2);
        }
        return sum;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
//        get input value for a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] factors = findFactors(number);
//        function call and display output
        System.out.print("Factors: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println("\nSum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));

    }
}
