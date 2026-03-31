package sortingAlgorithms;

public class BubbleSort {

    public static void bubbleSortMarks(int[] marks) {

        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }

    }

    public static void display(int[] marks) {
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] marks = {80, 77, 81, 75, 95, 92};
        bubbleSortMarks(marks);
        display(marks);
    }
}
