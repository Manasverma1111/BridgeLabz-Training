package Junit.src.main.java.org.example;

public class TimeoutTask {

    public String runningTask() throws InterruptedException {
        Thread.sleep(3000);
        return "Task Completed";
    }
}
