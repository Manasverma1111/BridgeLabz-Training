package com.controlflow;
import java.util.Scanner;

public class GreatestFactorOfaNumber {

    // function to find greatest factor using while loop
    public static int findGreatestFactor(int number) {
        int greatestFactor = 1;
        int counter = number - 1;

        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break; // Stop at the first largest factor
            }
            counter--;
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

