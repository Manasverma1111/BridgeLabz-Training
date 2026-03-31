import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExamProctor {

    // Stack to track question navigation
    private Stack<Integer> navigationStack;
    // HashMap to store questionID -> answer
    private Map<Integer, String> answersMap;
    // Correct answers for evaluation
    private Map<Integer, String> correctAnswers;

    public ExamProctor() {
        navigationStack = new Stack<>();
        answersMap = new HashMap<>();
        correctAnswers = new HashMap<>();
        loadCorrectAnswers();
    }

    private void loadCorrectAnswers() {
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");
        correctAnswers.put(4, "D");
    }

    // Track navigation to a question
    public void navigateToQuestion(int questionID) {
        navigationStack.push(questionID);
        System.out.println("Navigated to question: " + questionID);
    }

    // Store the answer for a question
    public void submitAnswer(int questionID, String answer) {
        answersMap.put(questionID, answer);
        System.out.println("Answer submitted for question " + questionID + ": " + answer);
    }

    // Auto-calculate the score
    public int calculateScore() {
        int score = 0;

        for (Map.Entry<Integer, String> entry : answersMap.entrySet()) {
            int questionID = entry.getKey();
            String answer = entry.getValue();

            if (correctAnswers.containsKey(questionID) && correctAnswers.get(questionID).equals(answer)) {
                score++;
            }
        }

        return score;
    }

    // Display navigation history
    public void displayNavigationHistory() {
        System.out.println("Navigation History:");
        while (!navigationStack.isEmpty()) {
            System.out.println("Visited question: " + navigationStack.pop());
        }
    }

    public static void main(String[] args) {
        ExamProctor proctor = new ExamProctor();

        // Simulate navigation and answering
        proctor.navigateToQuestion(1);
        proctor.submitAnswer(1, "A");

        proctor.navigateToQuestion(2);
        proctor.submitAnswer(2, "B");

        proctor.navigateToQuestion(3);
        proctor.submitAnswer(3, "D");

        proctor.navigateToQuestion(4);
        proctor.submitAnswer(4, "D");

        // Display navigation history
        proctor.displayNavigationHistory();
        // Calculate and display score
        int score = proctor.calculateScore();
        System.out.println("Final Score: " + score);
    }
}