package com.controlflow;
import java.util.Scanner;

public class LeapYearGregorianCal {

    // function to check leap year
    public static void checkLeapYear(int year) {
        if (year >= 1582) {
            if (year % 4 != 0) {
                System.out.println(year + " is not a Leap Year.");
            } else {
                if (year % 100 != 0) {
                    System.out.println(year + " is a Leap Year.");
                } else {
                    if (year % 400 == 0) {
                        System.out.println(year + " is a Leap Year.");
                    } else {
                        System.out.println(year + " is not a Leap Year.");
                    }
                }
            }
        } else {
            System.out.println("Year should be 1582 or later.");
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a year (>= 1582): ");
        int year = sc.nextInt();

        // function call
        checkLeapYear(year);

        sc.close();
    }
}
