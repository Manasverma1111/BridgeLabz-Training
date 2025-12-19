package com.controlflow;
import java.util.Scanner;

public class CountDigits {

    // function to count the number of digits
    static int countDigits(int number) {
        int count = 0;
        int temp = Math.abs(number); // handle negative numbers

        if (temp == 0) {
            return 1;
        }

        // loop until number becomes 0
        while (temp != 0) {
            temp = temp / 10; // remove last digit
            count++;           // increase count
        }

        return count;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

//        get input value for number
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

//        function call and display output
        int digits = countDigits(number);
        System.out.println("The number of digits in " + number + " is: " + digits);

        sc.close();
    }
}

