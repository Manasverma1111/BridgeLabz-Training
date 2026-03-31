package com.arrays;
import java.util.Scanner;

public class ReverseNumber {

    // function to reverse number
    public static void reverseNumber(long number) {

        // count digits
        int count = 0;
        long temp = number;
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        // store digits in correct order
        int[] digits = new int[count];
        int index = count - 1;

        while (number != 0) {
            digits[index] = (int) (number % 10);
            number /= 10;
            index--;
        }

        // print digits in reverse order
        System.out.print("Reversed Number: ");
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input value for number
        System.out.print("Enter a number: ");
        long number = sc.nextLong();

//        validation and function call
        if (number <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            reverseNumber(number);
        }

        sc.close();
    }
}
