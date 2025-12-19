package com.controlflow;
import java.util.Scanner;

public class EmployeeBonusCalc {

    // function to calculate bonus if years of service is greater then 5yrs
    public static double calculateBonus(double salary, int yearsOfService) {

        if (yearsOfService > 5) {
            return salary * 0.05; // 5% bonus
        } else {
            return 0; // No bonus
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input value for salary and years of service of an employee
        System.out.print("Enter the employee's salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter the years of service: ");
        int yearsOfService = sc.nextInt();

        // function call and calculate bonus
        double bonus = calculateBonus(salary, yearsOfService);

        // display output
        if (bonus > 0) {
            System.out.println("The bonus amount is: " + bonus);
        } else {
            System.out.println("Employee is not eligible for a bonus.");
        }

        sc.close();
    }
}

