package com.alpha;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter principal: ");
        float pricipal = sc.nextFloat();
        System.out.print("enter rate %: ");
        float rate = sc.nextFloat();
        System.out.print("enter time in years: ");
        float time = sc.nextInt();

        float simInt = calcSI(pricipal, rate, time);
        System.out.printf("The Simple Interest with principal %.2f, rate %.2f percent, and time %.2f years is %.2f", pricipal, rate, time, simInt);
    }

    public static float calcSI(float principal, float rate, float time) {

        float SI = (principal * rate * time) / 100;
        return SI;
    }
}
