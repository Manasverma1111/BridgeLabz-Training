package com.alpha;
import java.util.Scanner;

public class GuessTheNumberGame {
//    generate random guess using Math.random()
    static int generateGuess(int min, int max) {

        return (int)(Math.random() * (max - min + 1)) + min;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        int min = 1;
        int max = 100;
        char feedback;
        int attempts = 0;

        System.out.println("Think of a number between 1 and 100");

        while (true) {
            int guess = generateGuess(min, max);
            attempts++;

            System.out.println("My guess is: " + guess);
            System.out.print("Enter H (High), L (Low), or C (Correct): ");
            feedback = sc.next().toUpperCase().charAt(0);

            if (feedback == 'C') {
                System.out.println("I guessed your number in " + attempts + " attempts!");
                break;
            }
            else if (feedback == 'H') {
                max = guess - 1;
            }
            else if (feedback == 'L') {
                min = guess + 1;
            }
        }

        sc.close();
    }
}
