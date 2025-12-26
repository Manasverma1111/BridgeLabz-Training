package com.methods;
import java.util.Scanner;

public class EuclideanDistance {
//    method to calculate euclidean distance
    public static double euclideanDistance(double x1, double y1, double x2, double y2) {

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
//    method to find slope and y-intercept of line
    public static double[] lineEquation(double x1, double y1, double x2, double y2) {

        double slope, intercept;

        if (x2 - x1 == 0) {
            slope = Double.POSITIVE_INFINITY;
            intercept = Double.NaN;
        } else {
            slope = (y2 - y1) / (x2 - x1);
            intercept = y1 - slope * x1;
        }

        return new double[]{slope, intercept};
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
//        get input values for x1, y1, x2, and y2
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        double distance = euclideanDistance(x1, y1, x2, y2);
        System.out.printf("\nEuclidean Distance between (%.2f, %.2f) and (%.2f, %.2f): %.4f\n", x1, y1, x2, y2, distance);

        double[] line = lineEquation(x1, y1, x2, y2);

        if (Double.isInfinite(line[0])) {
            System.out.println("The line is vertical. Equation: x = " + x1);
        } else {
            System.out.printf("Equation of the line: y = %.4fx %.4f\n", line[0], line[1]);
        }

    }
}

