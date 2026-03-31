package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectService {

    @Todo(
            task = "Implement user authentication",
            assignedTo = "Tony",
            priority = "HIGH"
    )
    public void loginFeature() {
    }

    @Todo(
            task = "Add email notification support",
            assignedTo = "Steve"
    )
    public void notificationFeature() {
    }

    @Todo(
            task = "Optimize database queries",
            assignedTo = "Bruce",
            priority = "LOW"
    )
    public void databaseOptimization() {
    }
}

public class TodoAnnotation {

    public static void main(String[] args) {

        Class<ProjectService> clazz = ProjectService.class;
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println("Pending Tasks:\n");

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);

                System.out.println("Method Name : " + method.getName());
                System.out.println("Task        : " + todo.task());
                System.out.println("Assigned To : " + todo.assignedTo());
                System.out.println("Priority    : " + todo.priority());
                System.out.println();
            }
        }
    }
}
