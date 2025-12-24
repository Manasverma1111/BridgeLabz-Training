package com.methods;
import java.util.Scanner;
public class MaximumHandshakes {
    // function to calculate maximum number of handshakes
    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input values
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();
        int totalHandshakes = calculateHandshakes(numberOfStudents);
        System.out.println("The maximum number of possible handshakes is: " + totalHandshakes);

        sc.close();
    }
}
