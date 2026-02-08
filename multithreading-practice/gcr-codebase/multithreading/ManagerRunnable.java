package multithreading;
import java.util.Random;

class FileDownloaderRunnable implements Runnable {
    private String fileName;
    private Random random = new Random();

    public FileDownloaderRunnable(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        for (int i = 0; i <= 100; i += 25) {
            System.out.println("[" + Thread.currentThread().getName() +
                    "] Downloading " + fileName + ": " + i + "%");
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ManagerRunnable {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new FileDownloaderRunnable("Document.pdf"), "Thread-1");
        Thread t2 = new Thread(new FileDownloaderRunnable("Image.jpg"), "Thread-2");
        Thread t3 = new Thread(new FileDownloaderRunnable("Video.mp4"), "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!");
    }
}