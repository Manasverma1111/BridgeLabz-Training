package com.controlflow;

import java.util.Scanner;

public class RocketLaunch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
// input a number for value counter
        System.out.print("Enter countdown starting number: ");
        int counter = sc.nextInt();

        // Function call
        countdown(counter);

        sc.close();
    }
//function to count for rocket launch until 1
    public static void countdown(int counter) {
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
    }
}
