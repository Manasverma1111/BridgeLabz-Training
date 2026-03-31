class Persons {
    protected String name;
    protected int age;

    Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age : " + age);
    }
}

class Teacher extends Persons {
    private String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        displayBasicInfo();
        System.out.println("Role   : Teacher");
        System.out.println("Subject: " + subject);
    }
}

class Studentss extends Persons {
    private String grade;

    Studentss(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        displayBasicInfo();
        System.out.println("Role : Student");
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Persons {
    private String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        displayBasicInfo();
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
        Studentss student = new Studentss("Ananya", 16, "10th Grade");
        Staff staff = new Staff("Ramesh", 35, "Administration");

        teacher.displayRole();
        System.out.println();
        student.displayRole();
        System.out.println();
        staff.displayRole();
    }
}
