package com.arrays;
import java.util.Scanner;

public class VotingEligibility {

    // function to check voting eligibility
    public static void checkVotingElig(int age) {

        if (age < 0) {
            System.out.println("Invalid age entered: " + age);
        } else if (age >= 18) {
            System.out.println("The student with the age " + age + " can vote.");
        } else {
            System.out.println("The student with the age " + age + " cannot vote.");
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        int[] ages = new int[10];

        // get input values for ages
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            // function call
            checkVotingElig(ages[i]);
        }

        sc.close();
    }
}
