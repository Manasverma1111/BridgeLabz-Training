package com.string;
import java.util.Scanner;
import java.util.Random;

public class VotingEligibility {

    // method to generate random 2-digit ages for n students
    public static int[] generateAges(int n) {

        Random random = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = random.nextInt(90) + 10;
        }

        return ages;
    }

    // method to check voting eligibility
    // returns 2D String array: {age, canVote}
    public static String[][] checkVotingEligibility(int[] ages) {

        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }

        return result;
    }

    // method to display 2D array
    public static void displayTable(String[][] data) {

        System.out.println("\nAge\tCan Vote");
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for n
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        // create random ages
        int[] ages = generateAges(n);
        String[][] votingResult = checkVotingEligibility(ages);
        // display output
        displayTable(votingResult);

        sc.close();
    }
}

