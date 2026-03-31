package com.alpha;
import java.util.Scanner;

public class FibonacciSeqGenerator {
//    method to calculate and print Fibonacci sequence
    public static void printFibonacci(int terms) {

        int a = 0, b = 1;
        if (terms <= 0) {
            return;
        }
        if (terms >= 1) {
            System.out.print(a + " ");
        }
        if (terms >= 2) {
            System.out.print(b + " ");
        }

        for (int i = 3; i <= terms; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for number of terms
        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();

        printFibonacci(terms);

    }
}

