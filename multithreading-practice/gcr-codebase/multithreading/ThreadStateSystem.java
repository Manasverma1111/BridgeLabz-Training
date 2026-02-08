package multithreading;
import java.time.LocalTime;

class TaskRunner extends Thread {
    public TaskRunner(String name) {
        super(name);
    }

    public void run() {
        try {
            Thread.sleep(2000);
            for (int i = 0; i < 1000000; i++) {
                Math.sqrt(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class StateMonitor extends Thread {
    private Thread t1, t2;

    public StateMonitor(Thread t1, Thread t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("[Monitor] " + t1.getName() + " is in " + t1.getState() + " at " + LocalTime.now());
            System.out.println("[Monitor] " + t2.getName() + " is in " + t2.getState() + " at " + LocalTime.now());

            if (t1.getState() == State.TERMINATED && t2.getState() == State.TERMINATED) {
                running = false;
                System.out.println("Summary: Threads went through state transitions.");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadStateSystem {
    public static void main(String[] args) {
        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        StateMonitor monitor = new StateMonitor(t1, t2);

        monitor.start();
        t1.start();
        t2.start();
    }
}