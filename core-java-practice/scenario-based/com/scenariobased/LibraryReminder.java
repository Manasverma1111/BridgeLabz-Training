package com.scenariobased;
import java.util.Scanner;

public class LibraryReminder {
//    function to calculate fine
    static int calculateFine(int dueDate, int returnDate) {

        if (returnDate > dueDate) {
            int lateDays = returnDate - dueDate;
            return lateDays * 5;
        }

        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int totalFine = 0;
        System.out.println("Library Reminder App");

        for (int book = 1; book <= 5; book++) {

            System.out.println("\nBook " + book);
            System.out.print("Enter due date (day number): ");
            int dueDate = sc.nextInt();
            System.out.print("Enter return date (day number): ");
            int returnDate = sc.nextInt();
            int fine = calculateFine(dueDate, returnDate);
            totalFine += fine;

            if (fine > 0) {
                System.out.println("Late return. Fine: " + fine);
            } else {
                System.out.println("Returned on time. No fine.");
            }
        }

        System.out.println("\nTotal Fine for all books: " + totalFine);
    }
}
