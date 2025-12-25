package com.methods;
import java.util.Arrays;
import java.util.Scanner;

public class AnalyseFactors {
//    method to find factors and return as array
    public static int[] findFactors(int number) {

        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }
//    method to find greatest factor
    public static int greatestFactor(int[] factors) {

        int max = factors[0];
        for (int factor : factors) {
            if (factor > max) max = factor;
        }
        return max;
    }
//    method to find sum of factors
    public static int sumOfFactors(int[] factors) {

        int sum = 0;
        for (int factor : factors) sum += factor;
        return sum;
    }
//    method to find product of factors
    public static long productOfFactors(int[] factors) {

        long product = 1;
        for (int factor : factors) product *= factor;
        return product;
    }
//    method to find product of cubes of factors
    public static double productOfCubes(int[] factors) {

        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
//        get input value for a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] factors = findFactors(number);
//        function call and display output
        System.out.println("\nFactors of " + number + ": " + Arrays.toString(factors));
        System.out.println("Greatest Factor: " + greatestFactor(factors));
        System.out.println("Sum of Factors: " + sumOfFactors(factors));
        System.out.println("Product of Factors: " + productOfFactors(factors));
        System.out.println("Product of Cubes of Factors: " + productOfCubes(factors));

    }
}

