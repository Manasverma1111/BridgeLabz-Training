package com.alpha;

import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("base in cm: ");
        float base = sc.nextFloat();
        System.out.print("height in cm: ");
        float height = sc.nextFloat();

        float areaSqCm = 0.5f * base * height;
        float baseInInches = base / 2.54f;
        float heightInInches = height / 2.54f;
        float areaSqIn = 0.5f * baseInInches * heightInInches;

        System.out.println("The Area of the triangle in sq in is " + areaSqIn + " and sq cm is " + areaSqCm);
    }
}
