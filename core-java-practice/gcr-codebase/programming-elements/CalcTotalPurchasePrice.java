package com.alpha;

import java.util.Scanner;

public class CalcTotalPurchasePrice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("unit price (INR): ");
        float unitPrice = sc.nextFloat();
        System.out.print("quantity: ");
        int quantity = sc.nextInt();

        float totalPrice = unitPrice * quantity;

        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice
        );
    }
}
