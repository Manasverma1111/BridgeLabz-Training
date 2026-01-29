package Junit.src.test.java;

import Junit.src.main.java.org.example.DatabaseConnection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    private DatabaseConnection databaseConnection;
    @BeforeEach
    void setUp() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    @AfterEach
    void tearDown() {
        databaseConnection.disconnect();
    }

    @Test
    public void testConnected() {
        assertTrue(databaseConnection.isConnected());
    }

    @Test
    public void testDisconnected() {
        assertTrue(databaseConnection.isConnected());
    }
}
