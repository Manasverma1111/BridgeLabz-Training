package com.arrays;
import java.util.Scanner;

public class BMICalculator2D {

    // function to determine BMI status
    public static String getBMIStatus(double bmi) {
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

        // get input value for number of persons
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // get input values for height and weight of a person
        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));

            // height input
            while (true) {
                System.out.print("Enter height (in cm): ");
                personData[i][0] = sc.nextDouble();
                if (personData[i][0] > 0) break;
                System.out.println("Height must be positive. Please re-enter.");
            }

            // weight input
            while (true) {
                System.out.print("Enter weight (in kg): ");
                personData[i][1] = sc.nextDouble();
                if (personData[i][1] > 0) break;
                System.out.println("Weight must be positive. Please re-enter.");
            }
        }

        // calculate BMI and status
        for (int i = 0; i < number; i++) {
            double heightInMeters = personData[i][0] / 100;
            personData[i][2] = personData[i][1] / (heightInMeters * heightInMeters);
            weightStatus[i] = getBMIStatus(personData[i][2]);
        }

        // display results
        System.out.println();
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d -> Height: %.2f cm, Weight: %.2f kg, BMI: %.2f, Status: %s%n", (i + 1),
                    personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        sc.close();
    }
}

