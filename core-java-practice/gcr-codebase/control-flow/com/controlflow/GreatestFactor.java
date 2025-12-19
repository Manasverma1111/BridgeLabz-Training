package com.controlflow;
import java.util.Scanner;

public class GreatestFactor {

    // function to find greatest factor of a number
    public static int findGreatestFactor(int number) {

        int greatestFactor = 1;

        // loop from number-1 down to 1
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break; // Stop at the first (largest) factor
            }
        }
        return greatestFactor;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input value for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number > 1) {
            int greatestFactor = findGreatestFactor(number);
            System.out.println("The greatest factor of " + number + " is: " + greatestFactor);
        } else {
            System.out.println("Number should be greater than 1 to have a factor.");
        }

        sc.close();
    }
}

