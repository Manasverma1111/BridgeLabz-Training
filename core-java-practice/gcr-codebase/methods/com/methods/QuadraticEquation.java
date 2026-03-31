package com.methods;
import java.util.Scanner;

public class QuadraticEquation {
//    method to find roots of quadratic equation
    public static double[] findRoots(double a, double b, double c) {

        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta < 0) {
            return new double[0];
        }
        if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        }

        double sqrtDelta = Math.sqrt(delta);
        double root1 = (-b + sqrtDelta) / (2 * a);
        double root2 = (-b - sqrtDelta) / (2 * a);

        return new double[]{root1, root2};
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
//        get input values for a, b, and c
        System.out.print("Enter value of a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter value of b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter value of c: ");
        double c = scanner.nextDouble();

        double[] roots = findRoots(a, b, c);

        if (roots.length == 0) {
            System.out.println("No real roots exist.");
        } else if (roots.length == 1) {
            System.out.println("Only one root exists: " + roots[0]);
        } else {
            System.out.println("Root 1: " + roots[0]);
            System.out.println("Root 2: " + roots[1]);
        }

    }
}

