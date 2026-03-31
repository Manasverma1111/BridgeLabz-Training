package com.scenariobased;
import java.util.Scanner;

public class CoffeeCounterChronicles {

    // function to get price based on coffee type
    public static double getCoffeePrice(String coffeeType) {

        switch (coffeeType.toLowerCase()) {
            case "espresso":
                return 120.0;
            case "latte":
                return 150.0;
            case "cappuccino":
                return 180.0;
            default:
                return -1; // if the coffee entered is invalid
        }
    }

    // function to calculate total bill with GST
    public static double calculateTotal(double price, int quantity) {
        double bill = price * quantity;
        double gst = bill * 0.05; // 5% GST
        return bill + gst;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        keep on taking input from user until the user inputs exit
        while (true) {
            System.out.print("\nEnter coffee type (Espresso/Latte/Cappuccino) or 'exit': ");
            String coffeeType = sc.nextLine();

            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Thank you!");
                break;
            }

            double price = getCoffeePrice(coffeeType);
            if (price == -1) {
                System.out.println("Invalid coffee type.");
                continue;
            }

//            get input value for quantity
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

//            function call and display output
            double totalAmount = calculateTotal(price, quantity);
            System.out.println("Total Bill (including GST): ₹" + totalAmount);
        }

        sc.close();
    }
}

