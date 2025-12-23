package com.scenariobased;
import java.util.Scanner;

public class MetroFareDeduction {
    // function to calculate fare based on distance
    public static double calculateFare(int distance) {
        return (distance <= 5) ? 15 : (distance <= 15) ? 25 : 40;
    }
    // function to deduct fare from balance
    public static double deductBalance(double balance, double fare) {
        return balance - fare;
    }
    public static void main(String[] args) {
        // create scanner object
        Scanner sc = new Scanner(System.in);
        // initial smart card balance
        double balance = 200.0;
        // keep running until balance is exhausted or user exits
        while (true) {
            System.out.println("\nCurrent Balance: " + balance);
            System.out.print("Enter distance traveled (in km) or (-1) to exit: ");
            int distance = sc.nextInt();

            if (distance == -1) {
                System.out.println("Thank you");
                break;
            }
            // function call to calculate fare
            double fare = calculateFare(distance);
            if (fare > balance) {
                System.out.println("Insufficient balance");
                break;
            }
            // function call to deduct balance
            balance = deductBalance(balance, fare);
            System.out.println("Fare Deducted: " + fare);
        }

        sc.close();
    }
}
