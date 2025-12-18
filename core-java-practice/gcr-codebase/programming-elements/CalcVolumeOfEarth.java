package com.alpha;

public class CalcVolumeOfEarth {
    public static void main(String[] args) {

        double radiusKm = 6378;
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);
        double radiusMiles = radiusKm * 0.621371;
        double volumeMiles3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);

        System.out.printf("The volume of earth in cubic kilometers is %.3f and cubic miles is %.3f",volumeKm3, volumeMiles3
        );
    }
}
