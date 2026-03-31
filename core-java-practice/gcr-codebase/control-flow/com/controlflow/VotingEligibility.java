package com.controlflow;

import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
//      create scanner object
        Scanner sc = new Scanner(System.in);

        // get input value for age of a person
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        // call function and display output
        if (canVote(age)) {
            System.out.println("The person's age is " + age + " and can vote.");
        } else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }

        sc.close();
    }

//    function to check whether a person is eligible to vote or not
    public static boolean canVote(int age) {
        return age >= 18;
    }
}
