package Junit.src.main.java.org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    private static final DateTimeFormatter INPUT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final DateTimeFormatter OUTPUT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static String formatDate(String inputDate) {

        if (inputDate == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        try {
            LocalDate date = LocalDate.parse(inputDate, INPUT);
            return date.format(OUTPUT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }
}
