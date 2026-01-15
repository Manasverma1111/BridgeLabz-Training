package sortingAlgorithms;

public class SelectionSort {

    public static void selectionSortExamScores(int[] scores) {

        int n = scores.length;

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[min]) {
                    min = j;
                }
            }

            int temp = scores[min];
            scores[min] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {

        int[] scores = {87, 77, 90, 92, 82};
        selectionSortExamScores(scores);

        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}
