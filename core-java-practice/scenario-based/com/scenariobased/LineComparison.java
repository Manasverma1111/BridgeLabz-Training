package com.scenariobased;
import java.util.Scanner;

public class LineComparison {
//    method to calculate line length using distance formula
    private static double calculateLength(int x1, int y1, int x2, int y2) {

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
//        create scanner object
        System.out.println("Line Comparison Computation\n");
        Scanner sc = new Scanner(System.in);
//        Use Case 1: form a line and calculate length
        System.out.println("Use Case 1: Enter coordinates for Line 1");
//        gte input values for the co-ordinates
        System.out.print("Enter x1: ");
        int x1 = sc.nextInt();
        System.out.print("Enter y1: ");
        int y1 = sc.nextInt();
        System.out.print("Enter x2: ");
        int x2 = sc.nextInt();
        System.out.print("Enter y2: ");
        int y2 = sc.nextInt();

        double line1Length = calculateLength(x1, y1, x2, y2);
        System.out.println("Length of Line 1 = " + line1Length + "\n");

//        Use Case 2: check equality of two lines
        System.out.println("Use Case 2: Enter coordinates for Line 2");

        System.out.print("Enter x1: ");
        int a1 = sc.nextInt();
        System.out.print("Enter y1: ");
        int b1 = sc.nextInt();
        System.out.print("Enter x2: ");
        int a2 = sc.nextInt();
        System.out.print("Enter y2: ");
        int b2 = sc.nextInt();

        double line2Length = calculateLength(a1, b1, a2, b2);
        System.out.println("Length of Line 2 = " + line2Length + "\n");

        System.out.println("Use Case 2: Checking equality using equals()...");
        if (Double.valueOf(line1Length).equals(line2Length)) {
            System.out.println("Both lines are EQUAL in length.\n");
        } else {
            System.out.println("Lines are NOT equal in length.\n");
        }

//        Use Case 3: COMPARE TWO LINES
        System.out.println("Use Case 3: Comparing two lines using compareTo()...");

        int comparison = Double.valueOf(line1Length).compareTo(line2Length);

        if (comparison == 0) {
            System.out.println("Line 1 is EQUAL to Line 2");
        } else if (comparison > 0) {
            System.out.println("Line 1 is GREATER than Line 2");
        } else {
            System.out.println("Line 1 is LESS than Line 2");
        }

    }
}

