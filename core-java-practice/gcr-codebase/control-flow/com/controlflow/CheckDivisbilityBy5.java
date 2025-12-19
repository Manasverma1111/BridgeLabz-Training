package com.controlflow;

import java.util.Scanner;

//creating class CheckDivisibilityBy5 to check whether a given user input is divisible by 5 or not
//
public class CheckDivisbilityBy5 {
    public static void main(String[] args) {
//create a scanner object
        Scanner sc = new Scanner(System.in);

//        get one input variable for number
        System.out.print("Enter a number to check it's divisibility with 5: ");
        int number = sc.nextInt();
        boolean res = isDivBy5(number);

        if (res == true) {
            System.out.printf("Is the number %d divisible by 5? Yes", number);
        } else {
            System.out.printf("Is the number %d divisible by 5? No", number);
        }
    }

    public static boolean isDivBy5(int number) {

//checking if the number is divisible by 5 or not, and returning it
        return (number % 5 == 0);
    }
}
