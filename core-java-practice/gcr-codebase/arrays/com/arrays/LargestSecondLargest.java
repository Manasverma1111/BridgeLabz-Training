package com.arrays;
import java.util.Scanner;

public class LargestSecondLargest {
//function to find largest and second largest
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

//        get input value for number
        System.out.print("Enter a number: ");
        String number = sc.next();
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // store digits from string
        for (int i = 0; i < number.length(); i++) {

            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];

                for (int j = 0; j < digits.length; j++) {
                    temp[j] = digits[j];
                }
                digits = temp;
            }

            digits[index] = number.charAt(i) - '0';
            index++;
        }

//        function call
        if (index < 2) {
            System.out.println("Not enough digits to find second largest.");
        } else {
            findLargestAndSecondLargest(digits, index);
        }

        sc.close();
    }
}
