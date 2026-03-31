package com.scenariobased;
import java.util.Scanner;

public class ElectionBoothManager {
    // function to check voter eligibility
    public static boolean isEligible(int age) {
        return age >= 18;
    }
    // function to update vote count
    public static int[] recordVote(int vote, int[] votes) {

        switch (vote) {
            case 1:
                votes[0]++;
                break;
            case 2:
                votes[1]++;
                break;
            case 3:
                votes[2]++;
                break;
            default:
                System.out.println("Invalid vote choice.");
        }
        return votes;
    }
    // function to display final results
    public static void displayResults(int[] votes) {
        System.out.println("\nElection Results");
        System.out.println("Candidate 1 Votes: " + votes[0]);
        System.out.println("Candidate 2 Votes: " + votes[1]);
        System.out.println("Candidate 3 Votes: " + votes[2]);
    }

    public static void main(String[] args) {
        // create scanner object
        Scanner sc = new Scanner(System.in);
        // array to store votes of 3 candidates
        int[] votes = new int[3];
        // keep taking input until user enters exit code
        while (true) {
            System.out.print("\nEnter age (or -1 to exit): ");
            int age = sc.nextInt();
            if (age == -1) {
                System.out.println("Voting ended.");
                break;
            }
            if (!isEligible(age)) {
                System.out.println("Not eligible to vote.");
                continue;
            }

            System.out.println("Cast your vote:");
            System.out.println("1. Candidate A");
            System.out.println("2. Candidate B");
            System.out.println("3. Candidate C");
            int vote = sc.nextInt();
            // function call to record vote
            votes = recordVote(vote, votes);
        }
        // display final result
        displayResults(votes);

        sc.close();
    }
}
