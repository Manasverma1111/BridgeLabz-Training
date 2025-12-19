package com.alpha;

import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("enter radius of circle: ");
        float radius = sc.nextFloat();
        float res = calcArea(radius);
        System.out.printf("Area of circle with radius %.2f is %.2f", radius, res);
    }

    public static float calcArea(float radius) {
        float areaOfCircle = (float) Math.PI * radius * radius;
        return areaOfCircle;
    }
}
