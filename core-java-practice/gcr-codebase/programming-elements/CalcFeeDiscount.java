package com.alpha;

import java.util.Scanner;

public class CalcFeeDiscount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("fee (INR): ");
        double fee = sc.nextDouble();
        System.out.print("discount percentage: ");
        double discountPercent = sc.nextDouble();

        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;

        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
    }
}
