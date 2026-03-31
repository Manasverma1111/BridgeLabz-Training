package com.methods;
import java.util.Scanner;

public class QuotientnRemainder {
//    function to find quotient and remainder of number and divisor
    public static int[] findRemainderAndQuotient(int number, int divisor) {

        int remainder = number % divisor;
        int quotient = number / divisor;

        return new int[]{remainder, quotient};
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input values for number and divisor
        System.out.print("Enter number and divisor: ");
        int num = sc.nextInt();
        int div = sc.nextInt();

        int[] res = findRemainderAndQuotient(num, div);
        System.out.print("Remainder is " + res[0] + ", and Quotient is " + res[1]);
    }
}
