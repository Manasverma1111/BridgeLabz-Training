package com.methods;
import java.util.Scanner;

public class StudentVoteChecker {
//    method to check if a student can vote
    public boolean canStudentVote(int age) {

        if (age < 0) {
            return false;
        }
        if (age >= 18) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();

        int[] ages = new int[10];
//        get input value for age
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();

            boolean canVote = checker.canStudentVote(ages[i]);
            if (canVote) {
                System.out.println("Student " + (i + 1) + " is eligible to vote.");
            } else {
                System.out.println("Student " + (i + 1) + " is not eligible to vote.");
            }
        }

    }
}

