package Junit.src.test.java;

import Junit.src.main.java.org.example.DateFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    @Test
    void testValidDates() {

        assertEquals("12-05-2023", DateFormatter.formatDate("2023-05-12"));

        assertEquals("01-01-2024", DateFormatter.formatDate("2024-01-01"));
    }

    @Test
    void testInvalidDateFormat() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> DateFormatter.formatDate("12/05/2023"));

        assertEquals("Invalid date format", exception.getMessage());
    }

    @Test
    void testInvalidDateValue() {

        assertThrows(IllegalArgumentException.class,
                () -> DateFormatter.formatDate("2023-02-30"));
    }

    @Test
    void testNullDate() {

        assertThrows(IllegalArgumentException.class,
                () -> DateFormatter.formatDate(null));
    }
}
