import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;

    Alert(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " alert";
    }
}

public class NotificationFiltering {

    public static void main(String[] args) {

        List<Alert> alerts = Arrays.asList(
                new Alert("Emergency"),
                new Alert("Appointment"),
                new Alert("Billing")
        );

        Predicate<Alert> emergencyOnly = alert -> alert.type.equals("Emergency");
        alerts.stream().filter(emergencyOnly).forEach(System.out::println);
    }
}
