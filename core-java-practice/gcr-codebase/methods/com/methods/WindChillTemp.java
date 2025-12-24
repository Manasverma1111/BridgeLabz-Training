package com.methods;
import java.util.Scanner;

public class WindChillTemp {
//    function to calculate wind chill temperature
    public static double calcWindChillTemp(double temperature, double windSpeed) {

        double windChillTemp = 35.74 + (0.6215 * temperature) + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);

        return  windChillTemp;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input values for temperature and wind speed
        System.out.print("Enter Temperature (in Fahrenheit), and wind speed (in m/h): ");
        double tempInFahrenheit = sc.nextDouble();
        double windSpeedInMperH = sc.nextDouble();
//        function call and display output
        double res = calcWindChillTemp(tempInFahrenheit, windSpeedInMperH);
        System.out.printf("Wind Chill Temperature is %.2f ", res);
    }
}
