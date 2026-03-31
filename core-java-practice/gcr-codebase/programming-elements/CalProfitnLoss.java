package com.alpha;

public class CalProfitnLoss {
    public static void main(String[] args) {

        int costP = 129;
        int sellingP = 191;

        if (sellingP > costP) {
            float profit = sellingP - costP;
            float profitPer = (profit / costP) * 100;
            System.out.println("The Cost Price is INR " + costP + " and Selling Price is INR " + sellingP + "\nThe Profit is INR " + profit + " and the Profit Percentage is " + profitPer);

        } else if (costP > sellingP) {
            float loss = costP - sellingP;
            float lossPer = (loss / costP) * 100;
            System.out.println("The Cost Price is INR " + costP + " and Selling Price is INR " + sellingP + "\nThe Loss is INR " + loss + " and the Loss Percentage is " + lossPer);

        }
    }
}
