package com.arrays;
import java.util.Scanner;

public class FizzBuzzArr {

    // function to generate FizzBuzz array
    public static String[] generateFizzBuzz(int number) {

        String[] fizzBuzzArray = new String[number];

        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzArray[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                fizzBuzzArray[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                fizzBuzzArray[i - 1] = "Buzz";
            } else {
                fizzBuzzArray[i - 1] = String.valueOf(i);
            }
        }

        return fizzBuzzArray;
    }

    // function to display FizzBuzz results
    public static void displayFizzBuzz(String[] fizzBuzzArray) {

        for (int i = 0; i < fizzBuzzArray.length; i++) {
            System.out.println("Position " + (i + 1) + " = " + fizzBuzzArray[i]);
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input values for number
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            sc.close();
            return;
        }

        // function call, generate and display FizzBuzz output
        String[] fizzBuzzArray = generateFizzBuzz(number);
        displayFizzBuzz(fizzBuzzArray);

        sc.close();
    }
}

