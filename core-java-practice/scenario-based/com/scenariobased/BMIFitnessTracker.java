package com.scenariobased;
import java.util.Scanner;

public class BMIFitnessTracker {

    // function to calculate BMI
    public static double calculateBMI(double weight, double height) {

        return weight / (height * height);
    }

    // function to determine BMI category
    public static String getBMICategory(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else {
            return "Overweight";
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input values for weight in kg and height in m
        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();
        System.out.print("Enter height in meters: ");
        double height = sc.nextDouble();

//        function call and display outfit
        double bmi = calculateBMI(weight, height);
        String category = getBMICategory(bmi);
        System.out.printf("BMI: %.2f\n", bmi);
        System.out.println("Category: " + category);

        sc.close();
    }
}

