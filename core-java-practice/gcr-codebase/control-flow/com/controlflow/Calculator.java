package com.controlflow;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input value for first number and second number
        System.out.print("Enter first number: ");
        double number1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double number2 = sc.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        String op = sc.next();

        switch (op) {
            case "+":
                System.out.println("Result = " + (number1 + number2));
                break;
            case "-":
                System.out.println("Result = " + (number1 - number2));
                break;
            case "*":
                System.out.println("Result = " + (number1 * number2));
                break;
            case "/":
                if (number2 != 0) {
                    System.out.println("Result = " + (number1 / number2));
                } else {
                    System.out.println("Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid Operator.");
        }

        sc.close();
    }
}

