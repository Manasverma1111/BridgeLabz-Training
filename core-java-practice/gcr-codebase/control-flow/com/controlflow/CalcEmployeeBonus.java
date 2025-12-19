package com.controlflow;
import java.util.Scanner;

public class CalcEmployeeBonus {

    // function to calculate employee bonus
    public static double calculateBonus(double salary, int yearsOfService) {
        if (yearsOfService > 5) {
            return salary * 0.05; // 5% bonus
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // get input for value salary
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter years of service: ");
        int yearsOfService = sc.nextInt();

        // calculate bonus
        double bonus = calculateBonus(salary, yearsOfService);

        // display output
        if (bonus > 0) {
            System.out.println("The bonus amount is: " + bonus);
        } else {
            System.out.println("No bonus. Employee has less than or equal to 5 years of service.");
        }

        sc.close();
    }
}

