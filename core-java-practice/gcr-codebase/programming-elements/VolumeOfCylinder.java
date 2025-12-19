package com.alpha;

import java.util.Scanner;

public class VolumeOfCylinder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Radius of cylinder: ");
        float radius = sc.nextFloat();
        System.out.print("Enter Height of cylinder: ");
        float height = sc.nextFloat();

        float volCylinder = calcVolofCyilder(radius, height);
        System.out.printf("Volume of a cyilder with radius %.2f and height %.2f is %.2f", radius, height, volCylinder);

    }

    public static float calcVolofCyilder(float radius, float height) {

        float volOfCyilder = (float) Math.PI * radius * radius * height;
        return volOfCyilder;
    }
}
