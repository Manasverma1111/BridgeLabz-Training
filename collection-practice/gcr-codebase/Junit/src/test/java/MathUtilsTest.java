package Junit.src.test.java;

import Junit.src.main.java.org.example.MathUtils;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    public void testDivide() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> MathUtils.divide(10, 0)
        );

        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
