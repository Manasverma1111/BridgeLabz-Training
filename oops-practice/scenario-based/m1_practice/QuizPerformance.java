package m1_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;

class StudentRecord {

    protected String name;
    protected String dept;
    protected int quiz1;
    protected int quiz2;
    protected int quiz3;

    public StudentRecord(String name, String dept, int quiz1, int quiz2, int quiz3) {
        this.name = name;
        this.dept = dept;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
    }

    public String getName() {
        return name;
    }
    public String getDept() {
        return dept;
    }

    public int getTotal() {
        return quiz1 + quiz2 + quiz3;
    }

    public int getQuizScore(String quiz) {
        if (quiz.equals("Q1")) {
            return quiz1;
        }
        if (quiz.equals("Q2")) {
            return quiz2;
        }
        if (quiz.equals("Q3")) {
            return quiz3;
        }
        return -1;
    }
}

class CommandUtils {

    static List<StudentRecord> stdRecord = new ArrayList<>();

    public static void processCommand(Scanner sc) {

        String line = sc.nextLine();
        String[] parts = line.split(" ");

        String command = parts[0];

        // RECORD COMMAND
        if (command.equals("Record")) {

            String name = parts[1];
            String dept = parts[2];
            int quiz1 = Integer.parseInt(parts[3]);
            int quiz2 = Integer.parseInt(parts[4]);
            int quiz3 = Integer.parseInt(parts[5]);

            stdRecord.add(new StudentRecord(name, dept, quiz1, quiz2, quiz3));

            System.out.println("Record Added: " + name);
        }

        // TOP COMMAND
        else if (command.equals("Top")) {

            if (stdRecord.isEmpty()) {
                System.out.println("No Records Available");
                return;
            }

            String type = parts[1];

            // QUIZ RANKING
            if (type.startsWith("Q")) {

                int max = Integer.MIN_VALUE;

                for (StudentRecord s : stdRecord) {
                    max = Math.max(max, s.getQuizScore(type));
                }

                for (StudentRecord s : stdRecord) {
                    if (s.getQuizScore(type) == max) {
                        System.out.println(s.name + " " + max);
                    }
                }
            }

            // DEPARTMENT RANKING
            else {

                int max = Integer.MIN_VALUE;
                boolean found = false;

                for (StudentRecord s : stdRecord) {
                    if (s.dept.equals(type)) {
                        found = true;
                        max = Math.max(max, s.getTotal());
                    }
                }

                if (!found) {
                    System.out.println("Department Not Found");
                    return;
                }

                for (StudentRecord s : stdRecord) {
                    if (s.dept.equals(type) && s.getTotal() == max) {
                        System.out.println(s.name + " " + max);
                    }
                }
            }
        }
    }
}

public class QuizPerformance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            CommandUtils.processCommand(sc);

        }
    }
}
