package com.arrays;
import java.util.Scanner;

public class MultiplicationTab6To9 {

    // function to calculate multiplication results from 6 to 9
    public static int[] calculateTable(int num, int start, int end) {

        int size = end - start + 1;
        int[] multiRes = new int[size];
        for (int i = start; i <= end; i++) {
            multiRes[i - start] = num * i;
        }
        return multiRes;
    }

    // function to display multiplication table
    public static void displayTable(int num, int start, int end, int[] multiRes) {

        for (int i = start; i <= end; i++) {
            System.out.println(num + " * " + i + " = " + multiRes[i - start]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // get input values from user for number
        System.out.print("Enter a number to print its multiplication table from 6 to 9: ");
        int number = sc.nextInt();

        int start = 6;
        int end = 9;

        // calculate and store results
        int[] multiplicationResult = calculateTable(number, start, end);

        // function call
        displayTable(number, start, end, multiplicationResult);

        sc.close();
    }
}

