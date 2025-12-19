package com.controlflow;

public class DayOfWeek {

    // function to calculate day of week
    static int calculateDayOfWeek(int m, int d, int y) {

        int y0 = y - (14 - m) / 12;
        int x  = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        return d0;
    }

    public static void main(String[] args) {

        // read command-line arguments
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        // function call
        int day = calculateDayOfWeek(m, d, y);

        // display output
        System.out.printf("Day of the week (0=Sunday, 1=Monday, ... 6=Saturday): %d%n", day);
    }
}
