package com.methods;
import java.util.Scanner;

public class LeapYear {
//    method to check leap year based on given conditions
    public static boolean isLeapYear(int year) {

        if (year < 1582) {
            return false;
        }
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
//        get input value for a year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
//        function call and display output
        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is NOT a Leap Year.");
        }

    }
}

