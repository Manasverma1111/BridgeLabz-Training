package com.alpha;

import java.util.Scanner;

public class QuotientnRemainder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("number1 ");
        int number1 = sc.nextInt();
        System.out.print("number2 ");
        int number2 = sc.nextInt();

        int quotient = number1 / number2;
        int remainder = number1 % number2;

        System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two number " + number1 + " and " + number2
        );
    }
}
