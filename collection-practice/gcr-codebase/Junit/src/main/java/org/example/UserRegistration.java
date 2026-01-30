package Junit.src.main.java.org.example;
public class UserRegistration {

    public boolean registerUser(String username, String email, String password) {

        if (username == null || username.length() < 5) {
            throw new IllegalArgumentException("Invalid username");
        }

        if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Invalid password");
        }

        return true;
    }
}

