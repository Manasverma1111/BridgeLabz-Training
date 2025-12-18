package com.alpha;

public class DistKmToMiles {
    public static float kmToMiles(float kmDist) {
        float milesDist = (float) 1.6 * kmDist;
        return milesDist;
    }

    public static void main(String[] args) {
        float res = kmToMiles(10.8F);
        System.out.println("The distance 10.8 km in miles is " + res);
    }
}
