package com.arrays;
import java.util.Scanner;

public class SumOfArray {

    // function to calculate sum of array elements
    public static double calculateSum(double[] arr, int size) {

        double total = 0.0;
        for (int i = 0; i < size; i++) {
            total += arr[i];
        }
        return total;
    }

    // function to display array elements
    public static void displayArray(double[] arr, int size) {

        System.out.println("\nArray elements");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        int index = 0;

//        get input values for number
        System.out.println("Enter numbers (up to 10). Enter 0 or negative to exit: ");
        while (true) {
            System.out.print("Enter number: ");
            double num = sc.nextDouble();

            if (num <= 0) {
                break;
            }

            if (index == numbers.length) {
                System.out.println("Array is full. Cannot enter more numbers.");
                break;
            }

            numbers[index] = num;
            index++;
        }

//        function call and display output
        displayArray(numbers, index);
        double total = calculateSum(numbers, index);
        System.out.println("Sum of all numbers: " + total);

        sc.close();
    }
}

