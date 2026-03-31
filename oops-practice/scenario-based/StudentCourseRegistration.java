import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Personns {
    protected String name;
    protected int id;

    public Personns(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Studennt extends Personns {

    private List<String> courses = new ArrayList<>();
    private Map<String, Integer> grades = new HashMap<>();
    private static final int MAX_COURSE = 3;

    public Studennt(String name, int id) {
        super(name, id);
    }
    public List<String> getCourses() {
        return courses;
    }
    public Map<String, Integer> getGrades() {
        return grades;
    }
    public int getMaxCourse() {
        return MAX_COURSE;
    }

}

class CourseLimitExceededException extends Exception {
    public CourseLimitExceededException(String message) {
        super(message);
    }
}

abstract class RegistrationServices {
    abstract void enrollCourse(Studennt student, String course) throws CourseLimitExceededException;
    abstract void dropCoure(Studennt student, String course);
    abstract void addGrade(Studennt student, String course, int grade);
}

class RegistrationServicesImp extends RegistrationServices {

    @Override
    void enrollCourse(Studennt student, String course) throws CourseLimitExceededException {
        if (student.getCourses().size() >= student.getMaxCourse()) {
            throw new CourseLimitExceededException("Course Limit Exceeded");
        }
        student.getCourses().add(course);
    }

    @Override
    void dropCoure(Studennt student, String course) {
        student.getCourses().remove(course);
        student.getGrades().remove(course);
    }

    @Override
    void addGrade(Studennt student, String course, int grade) {
        student.getGrades().put(course, grade);
    }
}
public class StudentCourseRegistration {
    public static void main(String[] args) {

        Studennt student = new Studennt("Bruce", 101);
        RegistrationServices service = new RegistrationServicesImp();

        try {
            service.enrollCourse(student, "Java");
            service.enrollCourse(student, "DBMS");
            service.enrollCourse(student, "OS");
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        service.addGrade(student, "Java", 85);
        service.addGrade(student, "DBMS", 90);

        System.out.println("Courses Enrolled: " + student.getCourses());
        System.out.println("Grades: " + student.getGrades());
    }
}
