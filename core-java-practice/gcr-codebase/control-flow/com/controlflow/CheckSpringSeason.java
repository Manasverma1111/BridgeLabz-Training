package com.controlflow;

import java.util.Scanner;

public class CheckSpringSeason {
    public static void main(String[] args) {

//        create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the month in numbers: ");
        int month = sc.nextInt();
        System.out.print("Enter the day: ");
        int day = sc.nextInt();

        // function call display output
        if (isSpringSeason(month, day)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }

        sc.close();
    }
// function to check spring season
    static boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20);
    }

}
