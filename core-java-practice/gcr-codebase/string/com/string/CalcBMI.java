package com.string;
import java.util.Scanner;

public class CalcBMI {

    // function to calculate BMI and status
    public static String[] calcBMInStatus(double weight, double heightInCM) {

        double heightInM = heightInCM / 100;
        double bmi = weight / (heightInM * heightInM);
        String status;

        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[] {String.format("%.2f", heightInCM), String.format("%.2f", weight), String.format("%.2f", bmi), status};
    }

    // function to calculate BMI for all persons
    public static String[][] processBMI(double[][] data) {

        String[][] result = new String[10][4];
        for (int i = 0; i < 10; i++) {
            result[i] = calcBMInStatus(data[i][0], data[i][1]);
        }

        return result;
    }

    // function to display result in tabular format
    public static void displayBMIReport(String[][] report) {

        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");

        for (int i = 0; i < report.length; i++) {
            System.out.println(report[i][0] + "\t\t" + report[i][1] + "\t\t" + report[i][2] + "\t" + report[i][3]);
        }
    }

    // Main method
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][2]; // [weight, height]
//        get input values for weight and height
        System.out.println("Enter weight (kg) and height (cm) for 10 persons:");

        for (int i = 0; i < 10; i++) {

            System.out.println("\nPerson " + (i + 1));
            System.out.print("Weight (kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            data[i][1] = sc.nextDouble();
        }
//        function call and display output
        String[][] bmiReport = processBMI(data);
        displayBMIReport(bmiReport);
    }
}

