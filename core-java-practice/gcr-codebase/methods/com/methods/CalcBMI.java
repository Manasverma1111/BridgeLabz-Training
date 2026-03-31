package com.methods;
import java.util.Scanner;

public class CalcBMI {
//    method to calculate BMI and populate the 3rd column of the array
    public static void calculateBMI(double[][] data) {

        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightMeters = heightCm / 100;
            double bmi = weight / (heightMeters * heightMeters);

            data[i][2] = bmi;
        }
    }
//    method to determine BMI status for all persons
    public static String[] determineBMIStatus(double[][] data) {

        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {

            double bmi = data[i][2];

            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);

        double[][] bmiData = new double[10][3];
//        get input values
        for (int i = 0; i < bmiData.length; i++) {

            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            bmiData[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            bmiData[i][1] = scanner.nextDouble();
        }
//        display output
        calculateBMI(bmiData);
        String[] bmiStatus = determineBMIStatus(bmiData);
//        display output
        System.out.println("\nBMI Report:");
        System.out.println("Person\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");

        for (int i = 0; i < bmiData.length; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s%n", (i + 1), bmiData[i][0], bmiData[i][1], bmiData[i][2], bmiStatus[i]);
        }

    }
}

