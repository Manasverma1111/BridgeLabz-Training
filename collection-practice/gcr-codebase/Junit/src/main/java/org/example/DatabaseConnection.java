package Junit.src.main.java.org.example;

public class DatabaseConnection {

    private boolean connected = false;

    public void connect() {
        connected = true;
        System.out.println("Database connected");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Database disconnected");
    }

    public boolean isConnected() {
        return connected;
    }
}
