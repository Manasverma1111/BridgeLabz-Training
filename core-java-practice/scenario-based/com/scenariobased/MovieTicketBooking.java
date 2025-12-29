package com.scenariobased;
import java.util.Scanner;

public class MovieTicketBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int numberOfCustomers = sc.nextInt();
        sc.nextLine();

        for (int customer = 1; customer <= numberOfCustomers; customer++) {

            System.out.println("\nCustomer " + customer + " Booking");
            System.out.print("Enter movie type (Action/Comedy/Drama): ");
            String movieType = sc.nextLine();
            System.out.print("Enter seat type (Gold/Silver): ");
            String seatType = sc.nextLine();
            System.out.print("Do you want snacks? (yes/no): ");
            String snacksChoice = sc.nextLine();

            int seatPrice = 0;
            int snacksPrice = 0;

            switch (seatType.toLowerCase()) {
                case "gold":
                    seatPrice = 300;
                    break;
                case "silver":
                    seatPrice = 200;
                    break;
                default:
                    System.out.println("Invalid seat type. Booking skipped.");
                    continue;
            }

            if (snacksChoice.equalsIgnoreCase("yes")) {
                snacksPrice = 100;
            }

            int totalBill = seatPrice + snacksPrice;

            System.out.println("\nBooking Summary:");
            System.out.println("Movie Type  : " + movieType);
            System.out.println("Seat Type   : " + seatType);
            System.out.println("Snacks      : " + snacksChoice);
            System.out.println("Total Amount: ₹" + totalBill);
        }

        System.out.println("\nAll bookings completed successfully.");
    }
}
