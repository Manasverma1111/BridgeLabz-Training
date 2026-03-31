package java_streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class FileRead {

    public static void main(String[] args) {

        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        File src = new File(sourceFile);

        // Check if source file exists
        if (!src.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(destinationFile);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("Error occurred while reading or writing file.");
            e.printStackTrace();

        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing file streams.");
            }
        }
    }
}
