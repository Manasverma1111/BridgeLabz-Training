package java_streams;
import java.io.*;

public class PipedStream {

    public static void main(String[] args) {

        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writerThread = new Thread(new Writer(pos), "Writer-Thread");

            Thread readerThread = new Thread(new Reader(pis), "Reader-Thread");

            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.out.println("Error connecting piped streams: " + e.getMessage());
        }
    }
}

// Writer (Producer)
class Writer implements Runnable {

    private final PipedOutputStream outputStream;

    Writer(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try (PipedOutputStream pos = outputStream) {

            String message = "Inter-thread communication using Piped Streams";
            pos.write(message.getBytes());
            System.out.println("Writer sent data.");

        } catch (IOException e) {
            System.out.println("Writer IO Error: " + e.getMessage());
        }
    }
}

// Reader (Consumer)
class Reader implements Runnable {

    private final PipedInputStream inputStream;

    Reader(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try (PipedInputStream pis = inputStream) {

            int data;
            System.out.print("Reader received data: ");
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Reader IO Error: " + e.getMessage());
        }
    }
}
