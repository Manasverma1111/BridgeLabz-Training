package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    int priority();
    String assignedTo();
}

class TaskManager {

    @TaskInfo(priority = 1, assignedTo = "Steve")
    public void completeTask() {
        System.out.println("Task completed successfully");
    }
}

public class CustomAnnotation {

    public static void main(String[] args) throws Exception {

        TaskManager taskManager = new TaskManager();
        Class<?> clazz = taskManager.getClass();

        Method method = clazz.getMethod("completeTask");
        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

        System.out.println("Priority: " + taskInfo.priority());
        System.out.println("Assigned To: " + taskInfo.assignedTo());

        taskManager.completeTask();
    }
}
