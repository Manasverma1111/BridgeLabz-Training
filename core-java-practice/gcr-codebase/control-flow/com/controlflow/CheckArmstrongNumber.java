package com.controlflow;
import java.util.Scanner;

public class CheckArmstrongNumber {

    // function to check if a number is Armstrong
    public static boolean isArmstrong(int number) {
        int originalNumber = number; // store the original number
        int sum = 0; // initialize sum of cubes

        // loop until originalNumber becomes 0
        while (originalNumber != 0) {
            int digit = originalNumber % 10; // get last digit
            sum += digit * digit * digit;    // cube the digit and add to sum
            originalNumber = originalNumber / 10; // remove last digit
        }

        // Check if sum of cubes equals the original number
        return sum == number;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get in[ut value for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // function call to check Armstrong and display output
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong Number.");
        } else {
            System.out.println(number + " is not an Armstrong Number.");
        }

        sc.close();
    }
}

