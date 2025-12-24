package com.methods;
import java.util.Scanner;

public class FindSmallestnLargest {
//    function to find smallest and largest of three numbers
    public static int[] findSmnLargest(int number1, int number2, int number3) {

        int smallest = number1;
        int largest = number1;

        if (number2 < smallest) {
            smallest = number2;
        }
        if (number3 < smallest) {
            smallest = number3;
        }
        if (number2 > largest) {
            largest = number2;
        }
        if (number3 > largest) {
            largest = number3;
        }

        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        get input values for three numbers
        System.out.print("Enter three numbers: ");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();

        int[] res = findSmnLargest(number1, number2, number3);
        System.out.print("Smallest number is: " + res[0]);
        System.out.print("\nLargest number is: " + res[1]);
    }
}
