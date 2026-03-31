package com.methods;
import java.util.Scanner;

public class NumberSpecification {
//    method to calculate sum of proper divisors
    public static int sumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
//    method to check perfect number
    public static boolean isPerfect(int number) {

        return sumOfProperDivisors(number) == number;
    }
//    method to check abundant number
    public static boolean isAbundant(int number) {

        return sumOfProperDivisors(number) > number;
    }
//    method to check deficient number
    public static boolean isDeficient(int number) {

        return sumOfProperDivisors(number) < number;
    }
//    method to calculate factorial of a number
    public static int factorial(int n) {

        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
//    method to check strong number
    public static boolean isStrong(int number) {

        int temp = number;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }

        return sum == number;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
//        get input value for a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
//        function call and display output
        System.out.println("\nNumber Classification for: " + number);
        System.out.println("Is Perfect Number: " + isPerfect(number));
        System.out.println("Is Abundant Number: " + isAbundant(number));
        System.out.println("Is Deficient Number: " + isDeficient(number));
        System.out.println("Is Strong Number: " + isStrong(number));

    }
}

