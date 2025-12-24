package com.methods;
import java.util.Scanner;

public class CheckNumberType {
    public static int checkNumberSign(int number) {
        if (number > 0) {
            return 1;
        } else if (number < 0) {
            return -1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        get input values
        System.out.print("Enter an integer number: ");
        int number = sc.nextInt();
//        function call
        int result = checkNumberSign(number);
//        display output
        if (result == 1) {
            System.out.println("The number is Positive.");
        } else if (result == -1) {
            System.out.println("The number is Negative.");
        } else {
            System.out.println("The number is Zero.");
        }

    }
}
