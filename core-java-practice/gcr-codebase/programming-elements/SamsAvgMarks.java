package com.alpha;

public class SamsAvgMarks {
    public static double calAvgMarks(int maths, int physics, int chemistry) {
        double avgMarks = (maths + physics + chemistry) / 3;
        return avgMarks;
    }

    public static void main(String[] args) {
        double res = calAvgMarks(94, 95, 96);
        System.out.println("Sam's average mark in PCM is " + res);
    }
}
