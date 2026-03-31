package streamAPI;

import java.util.List;

public class AttendeeWelcomeMessage {

    public static void main(String[] args) {

        List<String> names = List.of("Steve Rogers", "Tony Stark", "Pepper Potts", "Bruce Banner", "Natasha Romanoff");

        names.stream().forEach(n -> System.out.println("Welcome, " + n));
    }
}
