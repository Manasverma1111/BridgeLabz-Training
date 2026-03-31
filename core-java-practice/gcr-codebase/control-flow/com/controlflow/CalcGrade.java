package com.controlflow;
import java.util.Scanner;

public class CalcGrade {

    // function to calculate average marks
    public static double calculateAverage(double physics, double chemistry, double maths) {

        return (physics + chemistry + maths) / 3;
    }

    // function to get Grade
    static String getGrade(double average) {

        if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else if (average >= 40) {
            return "E";
        } else {
            return "R";
        }
    }

    // function to get Remarks
    static String getRemarks(String grade) {

        switch (grade) {
            case "A":
                return "Level 4, above agency-normalized standards";
            case "B":
                return "Level 3, at agency-normalized standards";
            case "C":
                return "Level 2, below but approaching agency-normalized standards";
            case "D":
                return "Level 1, well below agency-normalized standards";
            case "E":
                return "Level 1-, too below agency-normalized standards";
            default:
                return "Remedial standards";
        }
    }

    public static void main(String[] args) {
// create scanner object
        Scanner sc = new Scanner(System.in);

        // get input values for physics, chemistry, and maths marks
        System.out.print("Enter Physics marks: ");
        double physics = sc.nextDouble();
        System.out.print("Enter Chemistry marks: ");
        double chemistry = sc.nextDouble();
        System.out.print("Enter Maths marks: ");
        double maths = sc.nextDouble();

        // function calls
        double average = calculateAverage(physics, chemistry, maths);
        String grade = getGrade(average);
        String remarks = getRemarks(grade);

        // display output
        System.out.println();
        System.out.printf("Average Marks: %.2f%%\n", average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);

        sc.close();
    }
}
