package com.string;
import java.util.Scanner;

public class CalcGrade {

    // method to generate random 2-digit PCM scores
    // returns 2D array: {Physics, Chemistry, Maths}
    public static int[][] generatePCMScores(int students) {

        int[][] scores = new int[students][3];

        for (int i = 0; i < students; i++) {
            scores[i][0] = (int) (Math.random() * 90) + 10;
            scores[i][1] = (int) (Math.random() * 90) + 10;
            scores[i][2] = (int) (Math.random() * 90) + 10;
        }

        return scores;
    }

    // method to calculate Total, Average, Percentage
    // returns 2D array: {Total, Average, Percentage}
    public static double[][] calculateStats(int[][] scores) {

        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {

            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return stats;
    }

    // method to calculate grade based on percentage
    // returns 2D array: {Grade}
    public static String[][] calculateGrades(double[][] stats) {

        String[][] grades = new String[stats.length][1];
        for (int i = 0; i < stats.length; i++) {
            double percentage = stats[i][2];

            if (percentage >= 80) {
                grades[i][0] = "A";
            } else if (percentage >= 70) {
                grades[i][0] = "B";
            } else if (percentage >= 60) {
                grades[i][0] = "C";
            } else if (percentage >= 50) {
                grades[i][0] = "D";
            } else if (percentage >= 40) {
                grades[i][0] = "E";
            } else {
                grades[i][0] = "R";
            }
        }

        return grades;
    }

    // Method to display scorecard in tabular format
    public static void displayScoreCard(int[][] scores, double[][] stats, String[][] grades) {

        System.out.println("\nScorecard");
        System.out.println();
        System.out.println("Students\tPhysics\tChemistry\tMaths\tTotal\tAverage\t\tPercentage\tGrade");
        System.out.println();
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2] + "\t" +
                            (int) stats[i][0] + "\t" + stats[i][1] + "\t\t" + stats[i][2] + "%\t\t" + grades[i][0]);
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input values for number of students
        System.out.print("Enter number of students: ");
        int students = sc.nextInt();
        int[][] pcmScores = generatePCMScores(students);
        double[][] stats = calculateStats(pcmScores);
        String[][] grades = calculateGrades(stats);

        displayScoreCard(pcmScores, stats, grades);

        sc.close();
    }
}
