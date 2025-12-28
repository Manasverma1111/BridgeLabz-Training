package com.alpha;
import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input for two dates
        System.out.print("Enter first date (yyyy-mm-dd): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine());
        System.out.print("Enter second date (yyyy-mm-dd): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine());

        if (date1.isBefore(date2)) {
            System.out.println("First date is before the second date");
        }
        else if (date1.isAfter(date2)) {
            System.out.println("First date is after the second date");
        }
        else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the same");
        }

    }
}

