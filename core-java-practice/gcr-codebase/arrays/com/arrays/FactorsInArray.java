package com.arrays;
import java.util.Scanner;
import java.util.Arrays;

public class FactorsInArray {

    // function to display the factors
    public static void displayFactors(int[] factors, int size) {

        System.out.print("Factors: ");
        for (int i = 0; i < size; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input values for number
        System.out.print("Enter a number to find its factors: ");
        int number = sc.nextInt();

        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // find factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // if array is full, double its size
                if (index == maxFactor) {
                    maxFactor *= 2;
                    int[] temp = new int[maxFactor];
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }

                factors[index] = i;
                index++;
            }
        }
        // function call display the factors
        displayFactors(factors, index);

        sc.close();
    }
}

