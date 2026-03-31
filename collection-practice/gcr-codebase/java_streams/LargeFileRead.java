package java_streams;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class LargeFileRead {

    public static void main(String[] args) {

        String filePath = "large-log-file.txt";
        String keyword = "error";

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath),
                        StandardCharsets.UTF_8))) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(keyword)) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("IO Error while reading file: " + e.getMessage());
        }
    }
}