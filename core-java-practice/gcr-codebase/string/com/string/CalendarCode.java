package com.string;
import java.util.*;

public class CalendarCode {
//    function to check for a leap year
    public static boolean isLeapYear(int year) {

        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }
//    function to get first day
    public static int getFirstDay(int month, int day, int year) {

        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;

        return (day + x + 31 * m0 / 12) % 7;
    }
//    function to print calendar
    public static void printCalendar(int month, int year) {

        String[] months = {"", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
            days[2] = 29;
        }

        System.out.println(months[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getFirstDay(month, 1, year);

        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= days[month]; day++) {

            System.out.printf("%3d ", day);

            if ((day + startDay) % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for month
        System.out.print("Enter month: ");
        int month = sc.nextInt();
//        get input value for year
        System.out.print("Enter year: ");
        int year = sc.nextInt();
//        function call
        printCalendar(month, year);
    }
}

