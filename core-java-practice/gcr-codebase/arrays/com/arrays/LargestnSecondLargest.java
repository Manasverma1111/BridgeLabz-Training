package com.arrays;
import java.util.Scanner;

public class LargestnSecondLargest {

    // function to find largest and second largest digit
    public static void findLargestAndSecondLargest(int[] digits, int count) {

        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < count; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

//        display output
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input values for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // extract digits and store in array
        while (number != 0) {
            if (index == maxDigit) {
                break;
            }
            digits[index] = number % 10;
            number = number / 10;
            index++;
        }

//        function call and computation
        if (index < 2) {
            System.out.println("Not enough digits to find second largest.");
        } else {
            findLargestAndSecondLargest(digits, index);
        }

        sc.close();
    }
}

