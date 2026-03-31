package com.alpha;

public class CalcDiscAmount {
    public static void main(String[] args) {

        int fee = 125000;
        float discountPercent = 10;
        float discount = (float) (125000 * 0.1);
        float payableFee = (fee - discount);

        System.out.println("The discount amount is INR " + discount + " and final discounted fee is " + payableFee);
    }
}
