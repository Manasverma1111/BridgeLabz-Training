package com.controlflow;
import java.util.Scanner;

public class MultiplesOfaNumber {

    // function to print multiples of number below 100
    public static void printMultiples(int number) {

        System.out.println("Multiples of " + number + " below 100 are:");

        for (int i = 100; i >= 1; i--) {
            if (i % number == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input value for number
        System.out.print("Enter a positive integer less than 100: ");
        int number = sc.nextInt();

        // check and display output
        if (number > 0 && number < 100) {
            printMultiples(number);
        } else {
            System.out.println("Please enter a valid positive integer less than 100.");
        }

        sc.close();
    }
}

