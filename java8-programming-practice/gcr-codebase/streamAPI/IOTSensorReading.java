package streamAPI;

import java.util.List;

public class IOTSensorReading {

    public static void main(String[] args) {

        List<Integer> readings = List.of(37, 29, 44, 17, 57, 61, 59, 18);
        int threshold = 35;

        readings.stream().filter(r -> r > threshold).forEach(System.out::println);
    }
}
