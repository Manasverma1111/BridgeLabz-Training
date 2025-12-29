package com.scenariobased;
import java.util.Scanner;

public class FestivalLuckyDraw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number;
        System.out.println("Festival Lucky Draw Started");

        while (true) {

            System.out.print("Enter your lucky number (0 to exit): ");
            number = sc.nextInt();

            if (number == 0) {
                System.out.println("Lucky draw ended.");
                break;
            }
            if (number < 0) {
                System.out.println("Invalid number! Try again.");
                continue;
            }
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("Congratulations! You won");
            } else {
                System.out.println("Better luck next time!");
            }
        }

    }
}

