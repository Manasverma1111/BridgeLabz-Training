package com.arrays;
import java.util.Scanner;

public class CalcGrade {

    // function to determine grade
    public static String calculateGrade(double percentage) {

        if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "R";
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input value for number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3]; // physics, chemistry, maths
        double[] percentage = new double[n];
        String[] grade = new String[n];

        // get input values for marks
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";

                System.out.print("Enter marks for " + subject + ": ");
                int value = sc.nextInt();

                if (value < 0) {
                    System.out.println("Marks cannot be negative. Re-enter student details.");
                    i--;
                    break;
                }
                marks[i][j] = value;
            }
        }

        // function call and calculate percentage and grade
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;
            grade[i] = calculateGrade(percentage[i]);
        }

        // display output
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf(
                    "Student %d -> Physics: %d, Chemistry: %d, Maths: %d, Percentage: %.2f%%, Grade: %s%n", (i + 1),
                    marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }

        sc.close();
    }
}

