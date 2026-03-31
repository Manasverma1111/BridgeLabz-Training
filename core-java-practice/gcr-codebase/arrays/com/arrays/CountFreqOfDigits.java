package com.arrays;
import java.util.Scanner;

public class CountFreqOfDigits {

    // function to find and display digit frequency
    public static void findDigitFrequency(long number) {

        // count digits
        int count = 0;
        long temp = number;

        while (temp != 0) {
            count++;
            temp /= 10;
        }

        // store digits in array
        int[] digits = new int[count];
        int index = count - 1;

        while (number != 0) {
            digits[index] = (int) (number % 10);
            number /= 10;
            index--;
        }

        int[] frequency = new int[10];

        // count frequency
        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++;
        }

        // display frequency
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i <= 9; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s)");
            }
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

//        function call and display output
        if (number <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            findDigitFrequency(number);
        }

        sc.close();
    }
}

