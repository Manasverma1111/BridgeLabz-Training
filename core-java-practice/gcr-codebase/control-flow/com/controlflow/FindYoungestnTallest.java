package com.controlflow;
import java.util.Scanner;

public class FindYoungestnTallest {

    // Function to find youngest friend
    public static String findYoungest(int amarAge, int akbarAge, int anthonyAge) {

        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            return "Amar";
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            return "Akbar";
        } else {
            return "Anthony";
        }
    }

    // Function to find tallest friend
    public static String findTallest(int amarHeight, int akbarHeight, int anthonyHeight) {

        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            return "Amar";
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            return "Akbar";
        } else {
            return "Anthony";
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get three input values for age
        System.out.print("Enter Amar's age: ");
        int amarAge = sc.nextInt();
        System.out.print("Enter Akbar's age: ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = sc.nextInt();

        // get three input values for heights
        System.out.print("Enter Amar's height (in cm): ");
        int amarHeight = sc.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        int akbarHeight = sc.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        int anthonyHeight = sc.nextInt();

        // function call and display output
        System.out.println("Youngest friend is " + findYoungest(amarAge, akbarAge, anthonyAge));
        System.out.println("Tallest friend is " + findTallest(amarHeight, akbarHeight, anthonyHeight));

        sc.close();
    }
}

