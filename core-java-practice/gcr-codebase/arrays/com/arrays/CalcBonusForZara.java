package com.arrays;
import java.util.Scanner;

public class CalcBonusForZara {

    // function to calculate bonus
    public static double calculateBonus(double salary, double yearsOfService) {

        if (yearsOfService > 5) {
            return salary * 0.05; // 5% bonus
        } else {
            return salary * 0.02; // 2% bonus
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        int size = 10;
        double[] salary = new double[size];
        double[] yearsOfService = new double[size];
        double[] bonus = new double[size];
        double[] newSalary = new double[size];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

//        get input values for salary, years of service
        for (int i = 0; i < size; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Enter Salary: ");
            salary[i] = sc.nextDouble();
            System.out.print("Enter Years of Service: ");
            yearsOfService[i] = sc.nextDouble();

            // input validation
            if (salary[i] <= 0 || yearsOfService[i] < 0) {
                System.out.println("Invalid input! Please enter valid values.");
                i--; // decrement index to re-enter data
                continue;
            }
        }

        for (int i = 0; i < size; i++) {
            bonus[i] = calculateBonus(salary[i], yearsOfService[i]);
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // display output
        System.out.printf("Total Old Salary: %.2f%n", totalOldSalary);
        System.out.printf("Total Bonus Paid: %.2f%n", totalBonus);
        System.out.printf("Total New Salary: %.2f%n", totalNewSalary);

        sc.close();
    }
}
