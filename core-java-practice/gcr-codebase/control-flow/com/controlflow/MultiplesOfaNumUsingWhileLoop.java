package com.controlflow;
import java.util.Scanner;

public class MultiplesOfaNumUsingWhileLoop {

    // function to print multiples of a number below 100 using while loop
    public static void printMultiples(int number) {

        System.out.println("Multiples of " + number + " below 100 are:");

        int counter = 100;

        while (counter >= 1) {
            if (counter % number == 0) {
                System.out.println(counter);
            }
            counter--;
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input value for number
        System.out.print("Enter a positive integer less than 100: ");
        int number = sc.nextInt();

        // function call compute multiples of a number and display output
        if (number > 0 && number < 100) {
            printMultiples(number);
        } else {
            System.out.println("Please enter a valid positive integer less than 100.");
        }

        sc.close();
    }
}

