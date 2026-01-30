package Junit.src.test.java;
import Junit.src.main.java.org.example.FileHandling;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlingTest {

    private FileHandling fileHandling;
    private final String testFile = "testFile.txt";

    @BeforeEach
    void setUp() {
        fileHandling = new FileHandling();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(testFile));
    }

    @Test
    void testWriteAndReadFile() throws IOException {

        String content = "JUnit File Testing";

        fileHandling.writeToFile(testFile, content);
        String result = fileHandling.readFromFile(testFile);

        assertEquals(content, result);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {

        fileHandling.writeToFile(testFile, "Test Content");

        assertTrue(Files.exists(Path.of(testFile)));
    }

    @Test
    void testReadNonExistingFileThrowsException() {

        assertThrows(
                IOException.class,
                () -> fileHandling.readFromFile("non_existing.txt")
        );
    }
}

