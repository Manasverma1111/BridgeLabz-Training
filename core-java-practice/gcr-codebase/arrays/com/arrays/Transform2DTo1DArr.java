package com.arrays;
import java.util.Scanner;

public class Transform2DTo1DArr {

    // function to display 1D array
    public static void display1DArray(int[] arr) {

        System.out.print("1D Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);

        // get input values for rows and columns
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();
        int[][] matrix = new int[rows][columns];

        // gte input values for 2D array
        System.out.println("Enter elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }

        // copy 2D array into 1D array
        int[] array1D = new int[rows * columns];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array1D[index] = matrix[i][j];
                index++;
            }
        }
        // function call and display the 1D array
        display1DArray(array1D);

        sc.close();
    }
}

