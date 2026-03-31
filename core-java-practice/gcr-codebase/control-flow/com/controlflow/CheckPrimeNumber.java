package com.controlflow;
import java.util.Scanner;

public class CheckPrimeNumber {

    // function to check if number is prime
    public static boolean isPrime(int number) {

        if (number <= 1) {
            return false; // numbers less than or equal to 1 are not prime
        }

        boolean isPrime = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false; // divisible by a number other than 1 and itself
                break;
            }
        }

        return isPrime;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input value for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

//        function call check if a number is prime and display output
        if (isPrime(number)) {
            System.out.println(number + " is a Prime Number.");
        } else {
            System.out.println(number + " is not a Prime Number.");
        }

        sc.close();
    }
}

