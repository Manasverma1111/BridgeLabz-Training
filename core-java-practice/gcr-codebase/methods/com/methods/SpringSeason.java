package com.methods;
public class SpringSeason {

    // function to check if the given date falls in Spring Season
    public static boolean isSpringSeason(int month, int day) {

        if ((month == 3 && day >= 20) ||
                (month == 4) ||
                (month == 5) ||
                (month == 6 && day <= 20)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        // command line input
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
//        function call
        boolean result = isSpringSeason(month, day);
//        display output
        if (result) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}

