package com.methods;
import java.util.Scanner;

public class TrigonometricFunctions {
//    function to calculate trigonometric functions
    public static double[] calcTrigoFuncs(double angle) {

        double radians = Math.toRadians(angle);

        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);

        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for angle
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
//        function call
        double[] res = calcTrigoFuncs(angle);
//        display output
        System.out.println("Sine of " + angle + " degrees is: " + res[0]);
        System.out.println("Cosine of " + angle + " degrees is: " + res[1]);
        System.out.println("Tangent of " + angle + " degrees is: " + res[2]);

    }
}

