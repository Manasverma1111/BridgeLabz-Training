package reflection;

import java.lang.reflect.Method;

class Task {
    public void run() throws InterruptedException {
        Thread.sleep(500);
    }
}

public class MethodExecutionTiming {

    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Class<?> cls = task.getClass();

        for (Method method : cls.getDeclaredMethods()) {
            long start = System.currentTimeMillis();
            method.invoke(task);
            long end = System.currentTimeMillis();

            System.out.println(method.getName() + " executed in " + (end - start) + " ms");
        }
    }
}
