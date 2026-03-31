// Unified Educational Course Hierarchy Program

class Courses {
    protected String courseName;
    protected int duration; // in hours

    Courses(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    String getCourseDetails() {
        return "Course: " + courseName + ", Duration: " + duration + " hours";
    }
}

class OnlineCourse extends Courses {
    protected String platform;
    protected boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    String getCourseDetails() {
        return super.getCourseDetails() +
                ", Platform: " + platform +
                ", Recorded: " + (isRecorded ? "Yes" : "No");
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; // percentage

    PaidOnlineCourse(String courseName, int duration, String platform,
                     boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    double getFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    String getCourseDetails() {
        return super.getCourseDetails() +
                ", Fee: " + fee +
                ", Discount: " + discount + "%" +
                ", Final Fee: " + getFinalFee();
    }
}

public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse("Java Full Stack", 60,"Coursera", true, 10000, 20);

        System.out.println(course.getCourseDetails());
    }
}
