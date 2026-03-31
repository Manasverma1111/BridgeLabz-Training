package com.alpha;

public class DistPenEqually {
    public static void main(String[] args) {

        int totPens = 14;
        int students = 3;
        int remPens = totPens % students;
        int eachStdRec = (totPens - remPens) / students;
        System.out.println("The pen per student is " + eachStdRec + " and the remaining pen not distributed is " + remPens);
    }
}
