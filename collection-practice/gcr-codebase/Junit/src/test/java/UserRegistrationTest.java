package Junit.src.test.java;

import Junit.src.main.java.org.example.UserRegistration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    private final UserRegistration registration = new UserRegistration();

    @Test
    void testValidUserRegistration() {

        assertTrue(registration.registerUser("stever","steve@example.com","Steve@963"));
    }

    @Test
    void testInvalidUsername() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> registration.registerUser(
                        "abc",
                        "user@example.com",
                        "Password1"
                )
        );

        assertEquals("Invalid username", exception.getMessage());
    }

    @Test
    void testInvalidEmail() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> registration.registerUser("validUser","invalid-email","Password1"
                )
        );

        assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    void testInvalidPassword() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> registration.registerUser(
                        "validUser",
                        "user@example.com",
                        "pass"
                )
        );

        assertEquals("Invalid password", exception.getMessage());
    }
}

