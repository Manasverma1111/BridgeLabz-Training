class Course {

    String courseName;
    int duration;       // in months
    double fee;

    static String instituteName = "BridgeLabz";

    Course(String courseName, int duration, double fee) {

        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {

        System.out.println("Institute Name : " + instituteName);
        System.out.println("Course Name    : " + courseName);
        System.out.println("Duration       : " + duration + " months");
        System.out.println("Course Fee     : ₹" + fee);
    }

    static void updateInstituteName(String newInstituteName) {

        instituteName = newInstituteName;
    }

    public static void main(String[] args) {

        Course c1 = new Course("Full Stack Java", 6, 45000);
        Course c2 = new Course("Data Structures", 4, 30000);

        c1.displayCourseDetails();
        System.out.println();
        Course.updateInstituteName("BridgeLabz Solutions");
        System.out.println();

        c2.displayCourseDetails();
    }
}
