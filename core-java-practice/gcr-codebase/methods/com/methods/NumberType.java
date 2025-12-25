package com.methods;
import java.util.Scanner;

public class NumberType {
//    method to check whether number is positive
    public static boolean isPositive(int number) {

        return number >= 0;
    }
//    method to check whether number is even
    public static boolean isEven(int number) {

        return number % 2 == 0;
    }
//    method to compare
    public static int compare(int number1, int number2) {

        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
//        gte input value for a number
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println();
        for (int i = 0; i < numbers.length; i++) {

            int num = numbers[i];

            if (isPositive(num)) {
                if (isEven(num)) {
                    System.out.println(num + " is Positive and Even");
                } else {
                    System.out.println(num + " is Positive and Odd");
                }
            } else {
                System.out.println(num + " is Negative");
            }
        }

        int comparisonResult = compare(numbers[0], numbers[numbers.length - 1]);
        System.out.println();
        if (comparisonResult == 1) {
            System.out.println("First element is greater than the last element.");
        } else if (comparisonResult == 0) {
            System.out.println("First and last elements are equal.");
        } else {
            System.out.println("First element is less than the last element.");
        }

    }
}

