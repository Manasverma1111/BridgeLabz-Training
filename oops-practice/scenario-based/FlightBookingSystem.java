import java.util.*;

class Flight {
    String flightId;
    String source;
    String destination;

    Flight(String flightId, String source, String destination) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
    }
}

class Booking {
    String customerName;
    Flight flight;

    Booking(String customerName, Flight flight) {
        this.customerName = customerName;
        this.flight = flight;
    }
}

public class FlightBookingSystem {
//    Array to store available flights
    static Flight[] flights = {
            new Flight("F101", "Delhi", "Mumbai"),
            new Flight("F102", "Delhi", "Bangalore"),
            new Flight("F103", "Mumbai", "Chennai")
    };

    // List to store bookings
    static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
//        Search flights (case-insensitive)
        System.out.println("Searching flights from delhi to mumbai:");
        Flight flight = searchFlight("delhi", "mumbai");

//        Book flight
        if (flight != null) {
            bookFlight("Steve Rogers", flight);
        }

//        Display bookings
        displayBookings();
    }

    // Search flights (case-insensitive)
    static Flight searchFlight(String source, String destination) {
        for (Flight f : flights) {
            if (f.source.equalsIgnoreCase(source) &&
                    f.destination.equalsIgnoreCase(destination)) {
                System.out.println("Flight Found: " + f.flightId);
                return f;
            }
        }
        System.out.println("No flight found");
        return null;
    }

//    Book flights
    static void bookFlight(String customerName, Flight flight) {
        bookings.add(new Booking(customerName, flight));
        System.out.println("Flight booked for " + customerName);
    }

//    Display bookings
    static void displayBookings() {
        System.out.println("\nBooking Details:");
        for (Booking b : bookings) {
            System.out.println("Customer: " + b.customerName + ", Flight: " + b.flight.flightId + ", Route: " + b.flight.source + " -> " + b.flight.destination);
        }
    }
}
