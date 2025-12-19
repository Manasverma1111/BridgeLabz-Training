package com.controlflow;

import java.util.Scanner;

public class LaunchRocket {
    public static void main(String[] args) {

//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input value for counter
        System.out.print("Enter countdown starting number: ");
        int counter = sc.nextInt();

//        function calling
        countdown(counter);
        sc.close();

    }

    public static void countdown(int counter) {
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
