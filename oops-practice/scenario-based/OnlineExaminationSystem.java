import java.util.*;

class ExamTimeExpiredException extends Exception {
    public ExamTimeExpiredException(String message) {
        super(message);
    }
}

// Student class
class Studentc {
    int studentId;
    String name;

    Studentc(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
}

class Question {
    String questionText;
    String correctAnswer;

    Question(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }
}

class Exam {
    String examName;
    List<Question> questions = new ArrayList<>();
    Map<Integer, List<String>> submissions = new HashMap<>();

    Exam(String examName) {
        this.examName = examName;
    }

    void addQuestion(Question q) {
        questions.add(q);
    }

    void submitAnswers(int studentId, List<String> answers) {
        submissions.put(studentId, answers);
    }
}

// Evaluation Strategy Interface
interface EvaluationStrategy {
    int evaluate(Exam exam, int studentId);
}

// Answers Evaluation (MCQ / exact match)
class ObjectiveEvaluation implements EvaluationStrategy {
    public int evaluate(Exam exam, int studentId) {
        int score = 0;
        List<String> answers = exam.submissions.get(studentId);

        for (int i = 0; i < exam.questions.size(); i++) {
            if (exam.questions.get(i).correctAnswer
                    .equalsIgnoreCase(answers.get(i))) {
                score++;
            }
        }
        return score;
    }
}

// Descriptive Evaluation (fixed marks per answer)
class DescriptiveEvaluation implements EvaluationStrategy {
    public int evaluate(Exam exam, int studentId) {
        return exam.questions.size(); // assume all answers evaluated as correct
    }
}

// Main class
public class OnlineExaminationSystem {

    public static void submitExam(
            Exam exam,
            Studentc student,
            List<String> answers,
            boolean timeExpired
    ) throws ExamTimeExpiredException {

        if (timeExpired) {
            throw new ExamTimeExpiredException("Exam time expired");
        }
        exam.submitAnswers(student.studentId, answers);
    }

    public static void main(String[] args) {

        Exam exam = new Exam("Java Basics");

        exam.addQuestion(new Question("What is JVM?", "Java Virtual Machine"));
        exam.addQuestion(new Question("What is OOP?", "Object Oriented Programming"));

        Studentc student = new Studentc(101, "Steve");

        List<String> answers = new ArrayList<>();
        answers.add("Java Virtual Machine");
        answers.add("Object Oriented Programming");

        try {
            submitExam(exam, student, answers, false);
        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }

        EvaluationStrategy evaluation = new ObjectiveEvaluation();
        int score = evaluation.evaluate(exam, student.studentId);

        System.out.println("Student: " + student.name);
        System.out.println("Score: " + score + "/" + exam.questions.size());
    }
}
