package com.methods;

public class UnitConvertor2 {
//    method to convert yards to feet
    public static double convertYardsToFeet(double yards) {

        double yards2feet = 3;
        return yards * yards2feet;
    }
//    method to convert feet to yards
    public static double convertFeetToYards(double feet) {

        double feet2yards = 0.333333;
        return feet * feet2yards;
    }
//    method to convert meters to inches
    public static double convertMetersToInches(double meters) {

        double meters2inches = 39.3701;
        return meters * meters2inches;
    }
//    method to convert inches to meters
    public static double convertInchesToMeters(double inches) {

        double inches2meters = 0.0254;
        return inches * inches2meters;
    }
//    method to convert inches to centimeters
    public static double convertInchesToCentimeters(double inches) {

        double inches2cm = 2.54;
        return inches * inches2cm;
    }
    public static void main(String[] args) {
//        function call and display output
        System.out.println("5 yards to feet: " + UnitConvertor2.convertYardsToFeet(5));
        System.out.println("9 feet to yards: " + UnitConvertor2.convertFeetToYards(9));
        System.out.println("2 meters to inches: " + UnitConvertor2.convertMetersToInches(2));
        System.out.println("20 inches to meters: " + UnitConvertor2.convertInchesToMeters(20));
        System.out.println("12 inches to centimeters: " + UnitConvertor2.convertInchesToCentimeters(12));
    }
}

