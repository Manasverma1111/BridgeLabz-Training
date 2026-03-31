package streamAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class LoggingTransactions {

    public static void main(String[] args) {

        List<Integer> Ids = List.of(102, 105, 209, 101, 211);
        Ids.forEach(id -> System.out.println(LocalDateTime.now() + " - Transaction Id: " + id));
    }
}
