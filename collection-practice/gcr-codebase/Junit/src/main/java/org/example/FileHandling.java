package Junit.src.main.java.org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandling {

    public void writeToFile(String filename, String content) throws IOException {
        Files.write(Path.of(filename), content.getBytes());
    }

    public String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}

