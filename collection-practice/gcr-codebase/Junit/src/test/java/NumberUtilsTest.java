package Junit.src.test.java;

import Junit.src.main.java.org.example.NumberUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void testNumberUtil(int n) {
        boolean expected = n % 2 == 0;
        assertEquals(expected, NumberUtils.isEven(n));
    }
}
