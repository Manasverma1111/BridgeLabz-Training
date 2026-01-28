import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TableAlreadyReservedException extends Exception {
    TableAlreadyReservedException(String message) {
        super(message);
    }
}

class Table {
    int tableNumber;

    Table(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}

class Reservation {
    int tableNumber;
    String customerName;
    String timeSlot;

    Reservation(int tableNumber, String customerName, String timeSlot) {
        this.tableNumber = tableNumber;
        this.customerName = customerName;
        this.timeSlot = timeSlot;
    }
}

class Restaurant {

    Map<Integer, Table> tableMap = new HashMap<>();
    List<Reservation> reservationList = new ArrayList<>();

    Restaurant(int totalTables) {
        for (int i = 1; i <= totalTables; i++) {
            tableMap.put(i, new Table(i));
        }
    }

    void reserveTable(int tableNumber, String customerName, String timeSlot)
            throws TableAlreadyReservedException {

        if (!tableMap.containsKey(tableNumber)) {
            System.out.println("Invalid table number");
            return;
        }

        for (Reservation r : reservationList) {
            if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
                throw new TableAlreadyReservedException("Table " + tableNumber + " is already reserved for " + timeSlot);
            }
        }

        reservationList.add(new Reservation(tableNumber, customerName, timeSlot));
        System.out.println("Table " + tableNumber + " reserved for " + timeSlot);
    }

    void cancelReservation(int tableNumber, String timeSlot) {
        boolean removed = reservationList.removeIf(
                r -> r.tableNumber == tableNumber &&
                        r.timeSlot.equals(timeSlot));

        if (removed) {
            System.out.println("Reservation cancelled for table " +
                    tableNumber + " at " + timeSlot);
        } else {
            System.out.println("No reservation found");
        }
    }

    void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");

        for (int tableNumber : tableMap.keySet()) {
            boolean booked = false;

            for (Reservation r : reservationList) {
                if (r.tableNumber == tableNumber &&
                        r.timeSlot.equals(timeSlot)) {
                    booked = true;
                    break;
                }
            }

            if (!booked) {
                System.out.println("Table " + tableNumber);
            }
        }
    }
}

public class RestaurantTableReservationSystem {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant(5);

        try {
            restaurant.reserveTable(1, "Tony Stark", "7PM-8PM");
            restaurant.reserveTable(1, "Steve Rogers", "8PM-9PM");
            restaurant.reserveTable(1, "Bruce Banner", "7PM-8PM");
        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }

        restaurant.showAvailableTables("7PM-8PM");
    }
}
