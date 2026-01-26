package java_streams;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class UpperCaseToLowerCase {

    public static void main(String[] args) {

        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(sourceFile, StandardCharsets.UTF_8));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile, StandardCharsets.UTF_8)))
        {

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(Character.toLowerCase(ch));
            }

            System.out.println("File processed successfully. Uppercase converted to lowercase.");

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
