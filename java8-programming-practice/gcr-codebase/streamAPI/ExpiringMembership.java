package streamAPI;

import java.time.LocalDate;
import java.util.List;

class Member {
    String name;
    LocalDate expiryDate;

    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return name + " - Expiry: " + expiryDate;
    }
}

public class ExpiringMembership {
    public static void main(String[] args) {

        List<Member> members = List.of(
                new Member("David", LocalDate.now().plusDays(10)),
                new Member("Alice", LocalDate.now().plusDays(40)),
                new Member("Bob", LocalDate.now().plusDays(25)),
                new Member("Charlie", LocalDate.now().plusDays(5))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        members.stream().filter(m -> !m.expiryDate.isBefore(today)&& !m.expiryDate.isAfter(next30Days)).forEach(System.out::println);
    }
}
