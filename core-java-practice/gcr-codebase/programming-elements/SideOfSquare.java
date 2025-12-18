package com.alpha;

import java.util.Scanner;

public class SideOfSquare {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("perimeter ");

        float perimeter = sc.nextFloat();
        float side = perimeter / 4;

        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
    }
}
