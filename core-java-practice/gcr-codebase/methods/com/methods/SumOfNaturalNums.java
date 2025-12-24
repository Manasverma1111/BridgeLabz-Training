package com.methods;

import java.util.Scanner;

public class SumOfNaturalNums {
    public static int sumOfNatNum(int n) {

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for n
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        int res = sumOfNatNum(n);
        System.out.print("Sum of first " + n + " natural numbers is: " + res);
    }
}
