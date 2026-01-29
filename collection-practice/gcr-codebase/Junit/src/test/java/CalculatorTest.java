package Junit.src.test.java;
import static org.junit.Assert.assertEquals;
import Junit.src.main.java.org.example.Calculator;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        int actualRes = c.add(2, 4);
        int expectedRes = 6;

        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void testsubtract() {
        Calculator c = new Calculator();
        int actualRes = c.subtract(8, 4);
        int expectedRes = 4;

        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void testMultiply() {
        Calculator c = new Calculator();
        int actualRes = c.multiply(2, 4);
        int expectedRes = 8;

        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void testDivide() {
        Calculator c = new Calculator();
        int actualRes = c.divide(16, 4);
        int expectedRes = 4;

        assertEquals(expectedRes, actualRes);
    }

}