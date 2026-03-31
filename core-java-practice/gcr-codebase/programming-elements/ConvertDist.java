package com.alpha;

import java.util.Scanner;

public class ConvertDist {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("distance in feet: ");
        float distanceInFeet = sc.nextFloat();

        float distanceInYards = distanceInFeet / 3;
        float distanceInMiles = distanceInYards / 1760;

        System.out.println("The distance in yards is " + distanceInYards + " while the distance in miles is " + distanceInMiles
        );
    }
}
