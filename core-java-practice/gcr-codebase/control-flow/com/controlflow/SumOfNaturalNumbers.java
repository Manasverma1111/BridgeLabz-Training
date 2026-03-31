package com.controlflow;

import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {

//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input value for a number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

//        function call and displaying the output
        if (isnaturalNum(number)) {
            int sum = sumOfNaturalNumber(number);
            System.out.println("The sum of " + number + " natural numbers is " + sum);
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }

        sc.close();

    }

//    function to check a number is natural number or not
    public static boolean isnaturalNum(int number) {

        return number >= 1;
    }

//    function to calculate the sum of naturals numbers
    public static int sumOfNaturalNumber(int n) {

        int sum = n * (n + 1) / 2;
        return sum;
    }
}
