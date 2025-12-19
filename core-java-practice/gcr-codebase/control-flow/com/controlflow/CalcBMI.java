package com.controlflow;
import java.util.Scanner;

public class CalcBMI {

    // function to calculate BMI
    public static double calculateBMI(double weightKg, double heightCm) {

        double heightInMeters = heightCm / 100.0; // convert cm to meters
        return weightKg / (heightInMeters * heightInMeters);
    }

    // function to determine weight status based on BMI
    static String determineStatus(double bmi) {

        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input value for weight in kg and height in cm
        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = sc.nextDouble();

        // function call and calculate BMI
        double bmi = calculateBMI(weight, height);
        // function call and determine weight status
        String status = determineStatus(bmi);

        // display output
        System.out.printf("BMI: %.2f%n", bmi);
        System.out.println("Weight Status: " + status);

        sc.close();
    }
}

