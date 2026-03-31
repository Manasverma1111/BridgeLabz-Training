package com.methods;
import java.util.Arrays;
import java.util.Scanner;

public class NumberOperation {
//    method to count digits in a number
    public static int countDigits(int number) {
        int count = 0;
        int temp = Math.abs(number);

        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }
//    method to store digits in an array
    public static int[] storeDigits(int number, int count) {

        int[] digits = new int[count];
        int temp = Math.abs(number);

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }
//    method to find sum of digits
    public static int sumOfDigits(int[] digits) {

        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
//    method to find sum of squares of digits
    public static double sumOfSquaresOfDigits(int[] digits) {

        double sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }
//    method to check Harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {

        int sum = sumOfDigits(digits);
        return sum != 0 && number % sum == 0;
    }
//    method to find frequency of each digit
    public static int[][] digitFrequency(int[] digits) {

        int[][] frequency = new int[10][2];

        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
        }

        // Count frequency
        for (int digit : digits) {
            frequency[digit][1]++;
        }

        return frequency;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for a number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int count = countDigits(number);
        int[] digits = storeDigits(number, count);

        System.out.println("\nDigits Array: " + Arrays.toString(digits));
        System.out.println("Count of digits: " + count);

        int sum = sumOfDigits(digits);
        double sumSquares = sumOfSquaresOfDigits(digits);

        System.out.println("Sum of digits: " + sum);
        System.out.println("Sum of squares of digits: " + sumSquares);
        System.out.println("Is Harshad Number: " + isHarshadNumber(number, digits));

        int[][] frequency = digitFrequency(digits);

        System.out.println();
        System.out.println("Digit\tFrequency");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println(frequency[i][0] + "\t" + frequency[i][1]);
            }
        }

    }
}

