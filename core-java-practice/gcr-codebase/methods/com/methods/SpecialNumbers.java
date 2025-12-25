package com.methods;
import java.util.Scanner;

public class SpecialNumbers {
//    method to check prime number
    public static boolean isPrime(int number) {

        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
//    method to check neon number
    public static boolean isNeon(int number) {

        int square = number * number;
        int sum = 0;

        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }
//    method to check spy number
    public static boolean isSpy(int number) {

        int temp = number;
        int sum = 0;
        int product = 1;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }
//    method to check automorphic number
    public static boolean isAutomorphic(int number) {

        int square = number * number;
        String numStr = Integer.toString(number);
        String squareStr = Integer.toString(square);

        return squareStr.endsWith(numStr);
    }
//    method to check buzz number
    public static boolean isBuzz(int number) {

        return (number % 7 == 0) || (number % 10 == 7);
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
//        get input value for a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
//        function call and display output
        System.out.println("\nNumber Checks for: " + number);
        System.out.println("Is Prime Number: " + isPrime(number));
        System.out.println("Is Neon Number: " + isNeon(number));
        System.out.println("Is Spy Number: " + isSpy(number));
        System.out.println("Is Automorphic Number: " + isAutomorphic(number));
        System.out.println("Is Buzz Number: " + isBuzz(number));

    }
}

