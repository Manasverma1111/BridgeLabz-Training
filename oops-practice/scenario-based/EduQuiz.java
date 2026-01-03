public class EduQuiz {
//    method to calculate score
    static int calculateScore(String[] correct, String[] student) {

        int score = 0;

        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(student[i])) {
                score++;
            }
        }
        return score;
    }
//    method to print detailed feedback
    static void printFeedback(String[] correct, String[] student) {

        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(student[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }
    }

    public static void main(String[] args) {
//        correct answers
        String[] correctAnswers = {"A", "B", "C", "D", "A", "C", "B", "D", "A", "C"};
        // Student answers
        String[] studentAnswers = {"a", "b", "c", "d", "b", "c", "b", "a", "a", "c"};
//        print feedback
        printFeedback(correctAnswers, studentAnswers);
        System.out.println();
//        calculate score
        int score = calculateScore(correctAnswers, studentAnswers);
        int totalQuestions = correctAnswers.length;
        double percentage = (score * 100.0) / totalQuestions;
//        display result
        System.out.println("Total Score: " + score + "/" + totalQuestions);
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 50) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}
