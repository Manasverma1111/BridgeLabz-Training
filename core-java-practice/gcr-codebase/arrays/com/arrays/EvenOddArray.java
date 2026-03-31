package com.arrays;
import java.util.Scanner;

public class EvenOddArray {

    // function to display array elements
    public static void displayArray(String label, int[] arr, int size) {
        System.out.print(label + ": ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input value for number
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        // check if input is a natural number
        if (number <= 0) {
            System.out.println("Please enter a natural number greater than 0.");
            sc.close();
            return;
        }

        int maxSize = number / 2 + 1;
        int[] oddNumbers = new int[maxSize];
        int[] evenNumbers = new int[maxSize];

        int oddIndex = 0;
        int evenIndex = 0;

        // separate odd and even numbers
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        // function call and display output
        displayArray("Odd numbers", oddNumbers, oddIndex);
        displayArray("Even numbers", evenNumbers, evenIndex);

        sc.close();
    }
}

