package com.methods;
import java.util.Scanner;

public class NumberOfChocolates {
//    function to calculate remaining chocolates and distributed chocolates
    public static int[] findDistAndRemChocolates(int chocolates, int children) {

        int distChocolates = chocolates / children;
        int remChocolates = chocolates % children;

        return new int[]{distChocolates, remChocolates};
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input values for number of chocolates and children
        System.out.println("Enter number of chocolates and children: ");
        int N = sc.nextInt();
        int M = sc.nextInt();
//        function call and display output
        int[] res = findDistAndRemChocolates(N, M);
        System.out.print("Number of chocolates each children got are " + res[0]);
        System.out.println("\nRemaining chocolates are " + res[1]);
    }
}
