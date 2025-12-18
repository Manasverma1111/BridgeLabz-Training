package com.alpha;

public class HarrysAge {
    public static int calcAge(int currAge) {
        int harryAge = 2024 - currAge;
        return harryAge;
    }

    public static void main(String[] args) {
        int res = calcAge(2000);
        System.out.println("Harry's age in 2024 is " + res);
    }
}
