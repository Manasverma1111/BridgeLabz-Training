package com.controlflow;

import java.util.Scanner;

public class CheckIfFirstNumSmallest {
    public static void main(String[] args) {
//create a scanner object
        Scanner sc = new Scanner(System.in);

//get three user input variables
        System.out.print("Enter the first number: ");
        int number1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int number2 = sc.nextInt();
        System.out.print("Enter the third number: ");
        int number3 = sc.nextInt();

//storing the result from function isFirstNumSmallest
        boolean res = isFirstNumSmallest(number1, number2, number3);

//        displaying the result
        if (res == true) {
            System.out.println("Is the first number the smallest? Yes");
        } else {
            System.out.println("Is the first number the smallest? No");
        }
         sc.close();
    }

    // function to check if the first  number is the smallest

    public static boolean isFirstNumSmallest(int number1, int number2, int number3) {

//        checking if the first input number1 is smallest of the three numbers
        if (number1 < number2 && number1 < number3) {
            return true;
        }
        return false;
    }
}
