package com.alpha;
import java.util.Scanner;

public class ConvertTemperature {
//    method to convert Fahrenheit to Celsius
    static double fahrenheitToCelsius(double fahrenheit) {

        return (fahrenheit - 32) * 5 / 9;
    }
//    method to convert Celsius to Fahrenheit
    static double celsiusToFahrenheit(double celsius) {

        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input value for temperature
        System.out.print("Enter temperature value: ");
        double temperature = sc.nextDouble();

        System.out.println("Choose conversion:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        int choice = sc.nextInt();
//        function call and display output
        if (choice == 1) {
            double result = fahrenheitToCelsius(temperature);
            System.out.println("Temperature in Celsius: " + result);
        }
        else if (choice == 2) {
            double result = celsiusToFahrenheit(temperature);
            System.out.println("Temperature in Fahrenheit: " + result);
        }
        else {
            System.out.println("Invalid choice");
        }

    }
}

