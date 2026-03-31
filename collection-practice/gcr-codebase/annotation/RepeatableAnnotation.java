package annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

class IssueTracker {

    @BugReport(description = "NullPointerException on login")
    @BugReport(description = "UI not responsive on mobile view")
    public void processIssue() {
        System.out.println("Processing issues...");
    }
}

public class RepeatableAnnotation {

    public static void main(String[] args) throws Exception {

        Class<IssueTracker> clazz = IssueTracker.class;
        Method method = clazz.getMethod("processIssue");

        BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

        for (BugReport bug : bugReports) {
            System.out.println("Bug: " + bug.description());
        }

        new IssueTracker().processIssue();
    }
}
