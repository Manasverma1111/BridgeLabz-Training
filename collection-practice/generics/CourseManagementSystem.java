package generics;
import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String evaluationMethod;

    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    public String getEvaluationMethod() {
        return evaluationMethod;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Written Examination");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignments & Projects");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research & Thesis");
    }
}

class Course<T extends CourseType> {

    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Course{name='" + courseName +
                "', department='" + department +
                "', evaluation='" + courseType.getEvaluationMethod() + "'}";
    }
}


class CourseManager {

    public static void displayCourses(List<? extends CourseType> courseTypes) {
        for (CourseType type : courseTypes) {
            System.out.println("Evaluation Method: " + type.getEvaluationMethod());
        }
    }
}

public class CourseManagementSystem {

    public static void main(String[] args) {

        Course<ExamCourse> math = new Course<>("Mathematics", "Science", new ExamCourse());
        Course<AssignmentCourse> cs = new Course<>("Data Structures", "Computer Science", new AssignmentCourse());
        Course<ResearchCourse> phd = new Course<>("AI Research", "Research Dept", new ResearchCourse());

        System.out.println(math);
        System.out.println(cs);
        System.out.println(phd);

        List<CourseType> courseTypes = new ArrayList<>();
        courseTypes.add(new ExamCourse());
        courseTypes.add(new AssignmentCourse());
        courseTypes.add(new ResearchCourse());

        CourseManager.displayCourses(courseTypes);
    }
}

