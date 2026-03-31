package functional_interfaces;
import java.util.function.Predicate;

public class TemperatureAlertSystem {

    public static void main(String[] args) {

        double threshold = 40.0;

        Predicate<Double> isOverheated = temp -> temp > threshold;
        double[] readings = {32.5, 38.0, 41.2, 45.0};

        for (double temp : readings) {
            if (isOverheated.test(temp)) {
                System.out.println("ALERT! Temperature crossed threshold: " + temp + "°C");
            } else {
                System.out.println("Temperature normal: " + temp + "°C");
            }
        }
    }
}
