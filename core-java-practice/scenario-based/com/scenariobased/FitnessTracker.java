package com.scenariobased;
public class FitnessTracker {

    public static void main(String[] args) {

        int[] pushUps = { 30, 0, 25, 40, 0, 35, 20 };
        int total = 0;
        int activeDays = 0;

        for (int count : pushUps) {

            if (count == 0) {
                continue;
            }
            total += count;
            activeDays++;
        }

        double average = (double) total / activeDays;
        System.out.println("Total push-ups in the week: " + total);
        System.out.println("Average push-ups per active day: " + average);
    }
}

