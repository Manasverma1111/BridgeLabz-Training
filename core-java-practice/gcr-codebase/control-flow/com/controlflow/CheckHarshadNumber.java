package com.controlflow;
import java.util.Scanner;

public class CheckHarshadNumber {

    // function to check if number is Harshad
    public static boolean isHarshad(int number) {

        int sum = 0;
        int orgNum = number; // store original number

        while (orgNum != 0) {
            int digit = orgNum % 10; // get last digit
            sum += digit;          // add digit to sum
            orgNum /= 10;            // remove last digit
        }

        // check if number is divisible by sum of digits
        return number % sum == 0;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input value for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

//        function call and check for Harshad number and display output
        if (isHarshad(number)) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is not a Harshad Number.");
        }

        sc.close();
    }
}

