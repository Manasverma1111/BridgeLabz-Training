package functional_interfaces;
public class BackgroundJobExecution {

    public static void main(String[] args) {

        Runnable backgroundJob = () -> {
            System.out.println("Background job started: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Background job completed");
        };

        Thread worker = new Thread(backgroundJob);
        worker.start();
        System.out.println("Main thread continues execution...");
    }
}
