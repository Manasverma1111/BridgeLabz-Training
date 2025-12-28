package com.alpha;
import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input for a date
        System.out.print("Enter date (yyyy-mm-dd): ");
        String inputDate = sc.nextLine();

        LocalDate date = LocalDate.parse(inputDate);
//        perform date arithmetic
        LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        System.out.println("Final Date: " + result);

    }
}

