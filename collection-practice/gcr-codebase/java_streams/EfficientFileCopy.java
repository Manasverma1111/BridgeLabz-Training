package java_streams;
import java.io.*;

public class EfficientFileCopy {

    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {

        String sourceFile = "C:\\BridgeLab-Training\\resources\\largefile.txt";            // e.g., 100MB file
        String bufferedDest = "buffered_copy.dat";
        String unbufferedDest = "unbuffered_copy.dat";

        copyWithUnbufferedStreams(sourceFile, unbufferedDest);
        copyWithBufferedStreams(sourceFile, bufferedDest);
    }

    // UNBUFFERED STREAM COPY
    private static void copyWithUnbufferedStreams(String source, String destination) {

        long startTime = System.nanoTime();

        try (
                FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream(destination)
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error in unbuffered file copy");
            e.printStackTrace();
            return;
        }

        long endTime = System.nanoTime();
        System.out.println("Unbuffered Stream Time: " +
                (endTime - startTime) / 1_000_000 + " ms");
    }

    // BUFFERED STREAM COPY
    private static void copyWithBufferedStreams(String source, String destination) {

        long startTime = System.nanoTime();

        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error in buffered file copy");
            e.printStackTrace();
            return;
        }

        long endTime = System.nanoTime();
        System.out.println("Buffered Stream Time: " +
                (endTime - startTime) / 1_000_000 + " ms");
    }
}
