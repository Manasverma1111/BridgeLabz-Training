import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentScore {

    public static int readStudentCount(Scanner sc) {

        int n;
        while (true) {
            try {
                System.out.print("Enter number of students: ");
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Number of students must be positive.");
                    continue;
                }
                return n;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a numeric value.");
                sc.next();
            }
        }
    }

    public static float[] readScores(Scanner sc, int n) {

        float[] scores = new float[n];

        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Enter score for student " + (i + 1) + ": ");
                    float score = sc.nextFloat();

                    if (score < 0) {
                        System.out.println("Score cannot be negative.");
                        continue;
                    }

                    scores[i] = score;
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Enter a numeric score.");
                    sc.next();
                }
            }
        }
        return scores;
    }

    public static float calculateAverage(float[] scores) {

        float avg = 0;
        for (float s : scores) {
            avg += s;
        }
        return avg / scores.length;
    }

    public static float findHighest(float[] scores) {

        float max = scores[0];
        for (float s : scores) {
            if (s > max)
                max = s;
        }
        return max;
    }

    public static float findLowest(float[] scores) {

        float min = scores[0];
        for (float s : scores) {
            if (s < min)
                min = s;
        }
        return min;
    }

    public static void displayAboveAverage(float[] scores, float average) {

        System.out.println("Scores above average:");
        boolean found = false;

        for (float s : scores) {
            if (s > average) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No scores above average.");
        }
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        function call and display output
        int n = readStudentCount(sc);
        float[] scores = readScores(sc, n);
        float average = calculateAverage(scores);
        float highest = findHighest(scores);
        float lowest = findLowest(scores);

        System.out.println("\nScore Analysis");
        System.out.println("Average Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        displayAboveAverage(scores, average);

    }
}
