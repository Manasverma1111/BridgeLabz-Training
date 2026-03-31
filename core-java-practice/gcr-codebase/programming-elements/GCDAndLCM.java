package com.alpha;

import java.util.Scanner;

public class GCDAndLCM {
//    method to find GCD
    public static int findGCD(int num1, int num2) {

        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        return num1;
    }
//    method to find LCM
    public static int findLCM(int num1, int num2) {
        int LCM = (num1 * num2) / findGCD(num1, num2);
        return LCM;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input for two number
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
//        function call and display output
        int gcd = findGCD(num1, num2);
        int lcm = findLCM(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);
    }
}
