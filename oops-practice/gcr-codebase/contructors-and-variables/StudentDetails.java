class Student {

    public int rollNumber;
    protected String name;
    private double cgpa;

    Student(int rollNumber, String name, double cgpa) {

        this.rollNumber = rollNumber;
        this.name = name;
        setCGPA(cgpa);
    }

    // Public getter for CGPA
    public double getCGPA() {
        return cgpa;
    }

    // Public setter for CGPA
    public void setCGPA(double cgpa) {
        if (cgpa >= 0 && cgpa <= 10) {
            this.cgpa = cgpa;
        } else {
            System.out.println("Invalid CGPA value");
        }
    }

    // Method to display basic student details
    void displayStudentDetails() {
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name);
        System.out.println("CGPA        : " + cgpa);
    }
}

// Child class
class PostgraduateStudent extends Student {

    String specialization;

    // Constructor
    PostgraduateStudent(int rollNumber, String name, double cgpa, String specialization) {
        super(rollNumber, name, cgpa);
        this.specialization = specialization;
    }

    // Method demonstrating access to protected member
    void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student Details");
        System.out.println("Name           : " + name); // protected member accessed
        System.out.println("Specialization : " + specialization);
        System.out.println("CGPA           : " + getCGPA()); // private via public method
    }
}

public class StudentDetails {

    public static void main(String[] args) {

        PostgraduateStudent pgStudent =
                new PostgraduateStudent(101, "Manas Verma", 8.6, "Computer Science");

        pgStudent.displayStudentDetails();
        System.out.println();

        pgStudent.displayPostgraduateDetails();

        // Modifying CGPA using public setter
        pgStudent.setCGPA(9.1);
        System.out.println("\nUpdated CGPA: " + pgStudent.getCGPA());
    }
}
