package Junit.src.test.java;
import Junit.src.main.java.org.example.PasswordValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testValidPasswords() {

        assertTrue(PasswordValidator.isValid("Password1"));
        assertTrue(PasswordValidator.isValid("Secure123"));
        assertTrue(PasswordValidator.isValid("JavaTest9"));
    }

    @Test
    void testInvalidPasswords() {

        assertFalse(PasswordValidator.isValid("Pass1"));
        assertFalse(PasswordValidator.isValid("password1"));
        assertFalse(PasswordValidator.isValid("Password"));
        assertFalse(PasswordValidator.isValid(null));
    }
}

