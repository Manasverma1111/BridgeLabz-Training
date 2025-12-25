package com.methods;
import java.util.Arrays;

public class RandomNumber {
//    method to generate an array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }

        return numbers;
    }
//    method to find average, minimum, and maximum
    public static double[] findAverageMinMax(int[] numbers) {

        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;

        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        double average = (double) sum / numbers.length;

        return new double[]{average, min, max};
    }

    // Main method
    public static void main(String[] args) {

        int size = 5;
        int[] randomNumbers = generate4DigitRandomArray(size);
        double[] result = findAverageMinMax(randomNumbers);

        System.out.println("Generated 4-digit random numbers:");
        System.out.println(Arrays.toString(randomNumbers));
        System.out.println();
        System.out.println("Average value: " + result[0]);
        System.out.println("Minimum value: " + result[1]);
        System.out.println("Maximum value: " + result[2]);
    }
}

