package com.scenariobased;
import java.util.Random;

public class EmployeeWageComputation {

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation\n");
        Random random = new Random();

//        Use Case 1: Check Employee Present or Absent
        int attendance = random.nextInt(2);
        boolean isPresent = attendance == 1;

        System.out.println("Use Case 1: Checking Employee Attendance...");
        if (isPresent) {
            System.out.println("Employee is Present\n");
        } else {
            System.out.println("Employee is Absent\n");
        }

        final int WAGE_PER_HOUR = 20;
        final int FULL_DAY_HOUR = 8;
        final int PART_TIME_HOUR = 8;

//        Use Case 2: Calculate Daily Wage
        System.out.println("Use Case 2: Calculating Daily Employee Wage...");
        int dailyWage = isPresent ? WAGE_PER_HOUR * FULL_DAY_HOUR : 0;
        System.out.println("Daily Wage: " + dailyWage + "\n");

//        Use Case 3: Add Part-Time Employee and Wage
        System.out.println("Use Case 3: Adding Part-Time Employee...");
        int empType = random.nextInt(3);
        int workingHours = 0;

        if (empType == 1) {
            workingHours = FULL_DAY_HOUR;
            System.out.println("Employee is Full-Time");
        } else if (empType == 2) {
            workingHours = PART_TIME_HOUR;
            System.out.println("Employee is Part-Time");
        } else {
            System.out.println("Employee is Absent");
        }

        int partTimeOrFullTimeWage = workingHours * WAGE_PER_HOUR;
        System.out.println("Wage: " + partTimeOrFullTimeWage + "\n");

//        Use Case 4: Solve using Switch Case -----
        System.out.println("Use Case 4: Solving using Switch Case...");
        empType = random.nextInt(3);
        switch (empType) {
            case 1:
                workingHours = FULL_DAY_HOUR;
                System.out.println("Switch: Full-Time Employee");
                break;
            case 2:
                workingHours = PART_TIME_HOUR;
                System.out.println("Switch: Part-Time Employee");
                break;
            default:
                workingHours = 0;
                System.out.println("Switch: Employee Absent");
        }
        System.out.println("Wage (Switch): " + (workingHours * WAGE_PER_HOUR) + "\n");

//        Use Case 5: Calculating Monthly Wage (20 days)
        System.out.println("Use Case 5: Calculating Wages for a Month (20 Working Days)...");
        int totalMonthlyWage = 0;
        for (int day = 1; day <= 20; day++) {
            empType = random.nextInt(3);
            switch (empType) {
                case 1: workingHours = FULL_DAY_HOUR; break;
                case 2: workingHours = PART_TIME_HOUR; break;
                default: workingHours = 0;
            }
            totalMonthlyWage += workingHours * WAGE_PER_HOUR;
        }
        System.out.println("Total Monthly Wage: " + totalMonthlyWage + "\n");

//        Use Case 6: Wage till 100 hours OR 20 days (whichever comes first)
        System.out.println("Use Case 6: Wage until 100 hours or 20 days reached...");
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while (totalHours < 100 && totalDays < 20) {
            totalDays++;
            empType = random.nextInt(3);

            switch (empType) {
                case 1: workingHours = FULL_DAY_HOUR; break;
                case 2: workingHours = PART_TIME_HOUR; break;
                default: workingHours = 0;
            }

            totalHours += workingHours;
            totalWage += workingHours * WAGE_PER_HOUR;
        }

        System.out.println("Total Days Worked: " + totalDays);
        System.out.println("Total Hours Worked: " + totalHours);
        System.out.println("Total Wage Earned: " + totalWage);
    }
}


