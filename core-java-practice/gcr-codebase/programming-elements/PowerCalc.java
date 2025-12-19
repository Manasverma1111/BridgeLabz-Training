package com.alpha;

import java.util.Scanner;

public class PowerCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter base: ");
        int base = sc.nextInt();
        System.out.print("enter exponent: ");
        int exponent = sc.nextInt();
        long result = power(base, exponent);
        System.out.println("Result: " + result);

        sc.close();
    }

    public static long power(int base, int exponent) {
        return (exponent == 0) ? 1 : base * power(base, exponent - 1);
    }
}


