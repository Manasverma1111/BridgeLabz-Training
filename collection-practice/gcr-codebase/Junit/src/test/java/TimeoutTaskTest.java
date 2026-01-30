package Junit.src.test.java;

import Junit.src.main.java.org.example.TimeoutTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class TimeoutTaskTest {

    @Test
    @Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
    public void testRunningTask() throws InterruptedException {

        TimeoutTask timeoutTask = new TimeoutTask();
        timeoutTask.runningTask();
    }
}
