package streamAPI;

import java.util.*;
import java.util.stream.Collectors;

class Claim {
    String type;
    double amount;

    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class InsuranceClaim {
    public static void main(String[] args) {

        List<Claim> claims = List.of(
                new Claim("Health", 5000),
                new Claim("Auto", 12000),
                new Claim("Health", 7000),
                new Claim("Home", 15000),
                new Claim("Auto", 8000)
        );

        Map<String, Double> avgGroups = claims.stream().collect(Collectors.groupingBy(c -> c.type, Collectors.averagingDouble(c -> c.amount)));

        avgGroups.forEach((type, avg) -> System.out.println(type + " : " + avg));


    }
}
