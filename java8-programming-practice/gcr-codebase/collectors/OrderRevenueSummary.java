package collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Orders {
    String name;
    double amount;

    public Orders(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    String getName() {
        return name;
    }
    double getAmount() {
        return amount;
    }
}
public class OrderRevenueSummary {

    public static void main(String[] args) {

        List<Orders> ordersList = List.of(
                new Orders("Charlie", 237.92),
                new Orders("Steve", 371.55),
                new Orders("Nebula", 208.00),
                new Orders("Steve", 400.78),
                new Orders("Nebula", 634.28),
                new Orders("Steve", 518.20)
        );

        Map<String, Double> groupedRevenue = ordersList.stream().collect(Collectors.groupingBy(Orders::getName, Collectors.summingDouble(Orders::getAmount)));
        System.out.println(groupedRevenue);
    }
}
