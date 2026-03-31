package com.methods;
public class UnitConvertor {
//    method to convert kilometers to miles
    public static double convertKmToMiles(double km) {

        double km2miles = 0.621371;
        return km * km2miles;
    }
//    method to convert miles to kilometers
    public static double convertMilesToKm(double miles) {

        double miles2km = 1.60934;
        return miles * miles2km;
    }
//    method to convert meters to feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
//    method to convert feet to meters
    public static double convertFeetToMeters(double feet) {

        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
    public static void main(String[] args) {
//        function call and display output
        System.out.println("10 km to miles: " + UnitConvertor.convertKmToMiles(10));
        System.out.println("6.2 miles to km: " + UnitConvertor.convertMilesToKm(6.2));
        System.out.println("5 meters to feet: " + UnitConvertor.convertMetersToFeet(5));
        System.out.println("16.4 feet to meters: " + UnitConvertor.convertFeetToMeters(16.4));
    }
}

