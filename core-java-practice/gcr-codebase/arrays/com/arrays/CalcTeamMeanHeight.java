package com.arrays;
import java.util.Scanner;

public class CalcTeamMeanHeight {

    // function to calculate mean height
    public static double calculateMean(double[] arr) {

        double sum = 0.0;
        for (double value : arr) {
            sum += value;
        }
        return sum / arr.length;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];

//        get input values for height of 11 players
        System.out.println("Enter the heights of 11 football players (in meters):");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        // function call and calculate mean height
        double meanHeight = calculateMean(heights);
        System.out.println("\nMean height of the football team: " + meanHeight + " meters");

        sc.close();
    }
}

