import java.util.Scanner;

public class StudentsScoreAnalyzer {

        static class InvalidScoreException extends Exception {
            public InvalidScoreException(String message) {
                super(message);
            }
        }

        public static void validateScores(int[] scores) throws InvalidScoreException {

            for (int score : scores) {
                if (score < 0 || score > 100) {
                    throw new InvalidScoreException("Invalid score found: " + score + ". Scores must be between 0 and 100.");
                }
            }
        }

    public static double calcAverage(int[] score) {

        int len = score.length;
        int sum = 0;
        for (int s : score) {
            sum += s;
        }

        return (double) sum / len;
    }

    public static int findMax(int[] score) {

        int max = score[0];
        for (int num : score) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public static int findMin(int[] score) {

        int min = score[0];
        for (int num : score) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] score = new int[n];

        System.out.println("Enter score of students: ");
        for (int i = 0; i < n; i++) {
            System.out.print("student " + (i + 1) + " score: ");
            score[i] = sc.nextInt();
        }

        try {
            validateScores(score);

            System.out.println("Average score: " + calcAverage(score));
            System.out.println("Highest score: " + findMax(score));
            System.out.println("Lowest score: " + findMin(score));
        } catch (InvalidScoreException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
