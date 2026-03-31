package com.methods;
import java.util.Arrays;
import java.util.Scanner;

public class AnalyseNumber {
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
//    method to check Duck Number (as per given hint)
    public static boolean isDuckNumber(int[] digits) {

        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }
//    method to check Armstrong Number
    public static boolean isArmstrongNumber(int number, int[] digits) {

        int sum = 0;
        int power = digits.length;

        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }
//    method to find the largest and the second largest digits
    public static int[] findLargestAndSecondLargest(int[] digits) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest};
    }
//    method to find the smallest and the second smallest digits
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }

        return new int[]{smallest, secondSmallest};
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
//        get input value of a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int count = countDigits(number);
        int[] digits = storeDigits(number, count);
//        function call and display output
        System.out.println("\nDigits Array: " + Arrays.toString(digits));
        System.out.println("Count of digits: " + count);
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrongNumber(number, digits));

        int[] largestValues = findLargestAndSecondLargest(digits);
        System.out.println("Largest digit: " + largestValues[0]);
        System.out.println("Second Largest digit: " + largestValues[1]);

        int[] smallestValues = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest digit: " + smallestValues[0]);
        System.out.println("Second Smallest digit: " + smallestValues[1]);

    }
}

