package java_streams;
import java.io.*;
import java.util.Arrays;

public class ImageByte {

    public static void main(String[] args) {

        String sourceImage = "input.jpg";
        String destinationImage = "output.jpg";

        try {
            // Step 1: Read image into byte array
            byte[] imageBytes = readImageAsByteArray(sourceImage);

            // Step 2: Write byte array back to new image
            writeByteArrayToImage(imageBytes, destinationImage);

            // Step 3: Verify both images
            verifyImages(sourceImage, destinationImage);

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }

    // Reads image file into byte array using ByteArrayOutputStream
    private static byte[] readImageAsByteArray(String filePath) throws IOException {

        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            System.out.println("Image converted to byte array.");
            return baos.toByteArray();
        }
    }

    // Writes byte array back to image using ByteArrayInputStream
    private static void writeByteArrayToImage(byte[] imageBytes, String outputPath)
            throws IOException {

        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Byte array written to new image file.");
        }
    }

    // Verifies whether both images are identical
    private static void verifyImages(String original, String copy) throws IOException {

        byte[] originalBytes = readAllBytes(original);
        byte[] copyBytes = readAllBytes(copy);

        if (Arrays.equals(originalBytes, copyBytes)) {
            System.out.println("Verification successful: Images are identical.");
        } else {
            System.out.println("Verification failed: Images differ.");
        }
    }

    // Utility method to read entire file as byte array
    private static byte[] readAllBytes(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }
}
