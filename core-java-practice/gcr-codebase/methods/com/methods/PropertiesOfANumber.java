package com.methods;
import java.util.Arrays;
import java.util.Scanner;

public class PropertiesOfANumber {
//    method to find count of digits
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
//    method to reverse the digits array
    public static int[] reverseDigits(int[] digits) {

        int[] reversed = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }
//    method to compare two arrays
    public static boolean compareArrays(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
//    method to check palindrome number
    public static boolean isPalindrome(int[] digits) {

        int[] reversed = reverseDigits(digits);
        return compareArrays(digits, reversed);
    }
//    method to check Duck Number (as per given hint)
    public static boolean isDuckNumber(int[] digits) {

        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
//        get input value for a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int count = countDigits(number);
        int[] digits = storeDigits(number, count);
        int[] reversedDigits = reverseDigits(digits);
//        function call and display output
        System.out.println("\nDigits Array: " + Arrays.toString(digits));
        System.out.println("Reversed Digits Array: " + Arrays.toString(reversedDigits));
        System.out.println("Are both arrays equal: " + compareArrays(digits, reversedDigits));
        System.out.println("Is Palindrome Number: " + isPalindrome(digits));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));

    }
}

