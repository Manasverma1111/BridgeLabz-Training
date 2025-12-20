package com.arrays;
import java.util.Scanner;

public class MultiplicationTable {

    // function to generate multiplication table
    public static int[] generateTable(int number) {

        int[] table = new int[10];
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }
        return table;
    }

    // function to display multiplication table
    public static void displayTable(int number, int[] table) {

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input values from user for number
        System.out.print("Enter a number to print its multiplication table: ");
        int number = sc.nextInt();
//        function call and generate table
        int[] table = generateTable(number);

        // display table
        displayTable(number, table);

        sc.close();
    }
}

