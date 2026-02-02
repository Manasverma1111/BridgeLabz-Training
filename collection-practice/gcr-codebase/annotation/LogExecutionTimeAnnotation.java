package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceService {

    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 1_000_000; i++) {
        }
    }

    @LogExecutionTime
    public void slowTask() {
        for (int i = 0; i < 50_000_000; i++) {
        }
    }

    public void helperTask() {
        System.out.println("Helper task (not measured)");
    }
}

public class LogExecutionTimeAnnotation {

    public static void main(String[] args) throws Exception {

        PerformanceService service = new PerformanceService();
        Class<?> clazz = service.getClass();

        for (Method method : clazz.getDeclaredMethods()) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long startTime = System.currentTimeMillis();
                method.invoke(service);
                long endTime = System.currentTimeMillis();

                long executionTime = endTime - startTime;

                System.out.println("Method: " + method.getName() + " | Execution Time: " + executionTime + " ns");
            }
        }
    }
}
