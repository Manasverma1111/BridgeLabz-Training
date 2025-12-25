package com.methods;
import java.util.Arrays;

public class PlayersHeight {
//    method to generate random heights between 150 and 250 cm
    public static int[] generateHeights(int size) {

        int[] heights = new int[size];

        for (int i = 0; i < size; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }

        return heights;
    }
//    method to find sum of heights
    public static int findSum(int[] heights) {

        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }
//    method to find mean height
    public static double findMean(int[] heights) {

        int sum = findSum(heights);
        return (double) sum / heights.length;
    }
//    method to find the shortest height
    public static int findShortest(int[] heights) {

        int min = heights[0];
        for (int height : heights) {
            if (height < min) {
                min = height;
            }
        }
        return min;
    }
//    method to find the tallest height
    public static int findTallest(int[] heights) {

        int max = heights[0];
        for (int height : heights) {
            if (height > max) {
                max = height;
            }
        }
        return max;
    }
    public static void main(String[] args) {

        int teamSize = 11;
        int[] heights = generateHeights(teamSize);

//        int sum = findSum(heights);
        double mean = findMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        System.out.println("Player Heights in cm:");
        System.out.println(Arrays.toString(heights));
        System.out.println();
        System.out.println("Shortest Height: " + shortest + " cm");
        System.out.println("Tallest Height: " + tallest + " cm");
        System.out.println("Mean Height: " + mean + " cm");
    }
}

