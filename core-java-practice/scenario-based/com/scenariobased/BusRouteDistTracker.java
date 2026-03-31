package com.scenariobased;
import java.util.Scanner;

public class BusRouteDistTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalDistance = 0;
        char choice;

        while (true) {

            System.out.print("Enter distance covered for this stop (in km): ");
            int distance = sc.nextInt();
            totalDistance += distance;

            System.out.println("Total distance covered: " + totalDistance + " km");

            System.out.print("Do you want to get off at this stop? (Y/N): ");
            choice = sc.next().toUpperCase().charAt(0);

            if (choice == 'Y') {
                System.out.println("Passenger got off the bus.");
                break;
            }
        }

        System.out.println("Total distance travelled: " + totalDistance + " km");
    }
}

