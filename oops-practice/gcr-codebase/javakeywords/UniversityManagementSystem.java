class Stud {

    static String universityName = "Global University";
    static int totalStudents = 0;

    final int rollNumber;

    String name;
    String grade;

    Stud(int rollNumber, String name, String grade) {

        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {

        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Update grade using instanceof
    void updateGrade(Object obj, String newGrade) {

        if (obj instanceof Stud) {
            Stud s = (Stud) obj;
            s.grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        }
    }

    // Display student details using instanceof
    void displayDetails(Object obj) {

        if (obj instanceof Stud) {
            Stud s = (Stud) obj;
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + s.rollNumber);
            System.out.println("Name: " + s.name);
            System.out.println();
            System.out.println("Grade: " + s.grade);
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {

        Stud s1 = new Stud(101, "Hemashree", "A");
        Stud s2 = new Stud(102, "Sharmila", "B");

        Stud.displayTotalStudents();
        s1.displayDetails(s1);
        s2.displayDetails(s2);
        s2.updateGrade(s2, "A");
        s2.displayDetails(s2);
    }
}
