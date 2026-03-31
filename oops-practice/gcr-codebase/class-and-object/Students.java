class Students {

    String name;
    String rollNumber;
    double mark1;
    double mark2;
    double mark3;
//    method to calculate grade
    char calculateGrade() {

        double average = (mark1 + mark2 + mark3) / 3;

        if (average >= 80) {
            return 'A';
        } else if (average >= 70) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else {
            return 'D';
        }
    }
//    method to display student details
    void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + mark1);
        System.out.println("Mark2: " + mark2);
        System.out.println("Mark3: " + mark3);
        System.out.println("Grade " + calculateGrade());
    }

    public static void main(String[] args) {

        Students student1 = new Students();
        student1.name = "Thamarai";
        student1.rollNumber = "ECE001";
        student1.mark1 = 80.0;
        student1.mark2 = 70.0;
        student1.mark3 = 75.0;
        student1.displayDetails();

        Students student2 = new Students();
        student2.name = "Kannan";
        student2.rollNumber = "CSC002";
        student2.mark1 = 60.0;
        student2.mark2 = 65.0;
        student2.mark3 = 50.0;
        student2.displayDetails();
    }
}

