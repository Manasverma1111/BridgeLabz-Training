package com.arrays;
import java.util.Scanner;

public class BMICalculator {

    // function to determine BMI status
    public static String getBMIStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input value for number of persons
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[] height = new double[n];   // in cm
        double[] weight = new double[n];   // in kg
        double[] bmi = new double[n];
        String[] status = new String[n];

        // get input values for height and weight of a person
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1));
            System.out.print("Enter height (in cm): ");
            height[i] = sc.nextDouble();
            System.out.print("Enter weight (in kg): ");
            weight[i] = sc.nextDouble();
        }

        // calculate BMI and status
        for (int i = 0; i < n; i++) {
            double heightInMeters = height[i] / 100; // convert cm to meters
            bmi[i] = weight[i] / (heightInMeters * heightInMeters);
            status[i] = getBMIStatus(bmi[i]);
        }

        // display results
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d -> Height: %.2f cm, Weight: %.2f kg, BMI: %.2f, Status: %s%n",
                    (i + 1), height[i], weight[i], bmi[i], status[i]);
        }

        sc.close();
    }
}
