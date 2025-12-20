package com.arrays;
import java.util.Scanner;

public class YoungestTallestFriend {

    // function to find index of tallest friend
    public static int findTallest(double[] height) {

        int maxHeight = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[maxHeight]) {
                maxHeight = i;
            }
        }
        return maxHeight;
    }

    // function to find index of youngest friend
    public static int findYoungest(int[] age) {

        int minIndex = 0;
        for (int i = 1; i < age.length; i++) {
            if (age[i] < age[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }


    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] height = new double[3];

        // get input values for age and height
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for " + names[i]);

            System.out.print("Enter Age: ");
            age[i] = sc.nextInt();
            System.out.print("Enter Height (in cm): ");
            height[i] = sc.nextDouble();
        }

        int youngestIndex = findYoungest(age);
        int tallestIndex = findTallest(height);

        // display output
        System.out.println("\n");
        System.out.println("Youngest Friend: " + names[youngestIndex] + " (Age: " + age[youngestIndex] + " years)");

        System.out.println("Tallest Friend: " + names[tallestIndex] +
                " (Height: " + height[tallestIndex] + " cm)");

        sc.close();
    }
}

