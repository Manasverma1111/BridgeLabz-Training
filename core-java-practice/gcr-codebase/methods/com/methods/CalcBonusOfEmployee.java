package com.methods;

public class CalcBonusOfEmployee {
//    method to generate salary and years of service for 10 employees
    public static int[][] generateEmployeeData(int numEmployees) {

        int[][] data = new int[numEmployees][2];

        for (int i = 0; i < numEmployees; i++) {
            int salary = (int) (Math.random() * 90000) + 10000;
            int yearsOfService = (int) (Math.random() * 10) + 1;

            data[i][0] = salary;
            data[i][1] = yearsOfService;
        }

        return data;
    }
//    method to calculate bonus and new salary
    public static double[][] calculateBonusAndNewSalary(int[][] data) {

        double[][] result = new double[data.length][2];

        for (int i = 0; i < data.length; i++) {
            int salary = data[i][0];
            int years = data[i][1];
            double bonus;

            if (years > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }

            double newSalary = salary + bonus;
            result[i][0] = bonus;
            result[i][1] = newSalary;
        }

        return result;
    }
//    method to calculate total old salary, new salary, and total bonus
    public static void displayTotals(int[][] employeeData, double[][] bonusData) {

        int totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("\nEmployee Bonus Details (Zara Company)\n");
        System.out.printf("%-10s %-12s %-15s %-12s %-12s\n", "Emp No", "Old Salary", "Years Service", "Bonus", "New Salary");

        for (int i = 0; i < employeeData.length; i++) {
            int oldSalary = employeeData[i][0];
            int years = employeeData[i][1];
            double bonus = bonusData[i][0];
            double newSalary = bonusData[i][1];

            System.out.printf("%-10d %-12d %-15d %-12.2f %-12.2f\n", (i + 1), oldSalary, years, bonus, newSalary);
            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;
        }

        System.out.println("\nTotals:");
        System.out.printf("Total Old Salary: %d\n", totalOldSalary);
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
    }
    public static void main(String[] args) {

        int numEmployees = 10;
        int[][] employeeData = generateEmployeeData(numEmployees);
        double[][] bonusData = calculateBonusAndNewSalary(employeeData);
//        function call and display output
        displayTotals(employeeData, bonusData);
    }
}

