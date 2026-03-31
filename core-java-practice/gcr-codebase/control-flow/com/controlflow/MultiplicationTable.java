package com.controlflow;
import java.util.Scanner;

public class MultiplicationTable {

    // Function to print multiplication table from 6 to 9
    public static void printTable(int number) {
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // get input for value number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Print multiplication table
        printTable(number);

        sc.close();
    }
}
