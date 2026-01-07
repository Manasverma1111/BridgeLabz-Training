import java.util.ArrayList;
import java.util.List;

interface FareCalculator {
    double calculateFare(double distance);
}

class NormalFare implements FareCalculator {
    @Override
    public double calculateFare(double distance) {
        return distance * 15;
    }
}

class PeakFare implements FareCalculator {
    @Override
    public double calculateFare(double distance) {
        return distance * 20;
    }
}

class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Driver {
    private int driverId;
    private String name;
    private boolean available;

    public Driver(int driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status) {
        this.available = status;
    }

    public String getName() {
        return name;
    }
}

class Ride {
    private User user;
    private Driver driver;
    private double distance;
    private double fare;

    public Ride(User user, Driver driver, double distance, double fare) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = fare;
    }

    public void displayRide() {
        System.out.println("User: " + user.getName());
        System.out.println("Driver: " + driver.getName());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: " + fare);
        System.out.println();
    }
}

class RideServices {

    private List<Driver> drivers = new ArrayList<>();
    private List<Ride> rideHistory = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    private Driver assignDriver() throws NoDriverAvailableException {

        for (Driver dr : drivers) {
            if (dr.isAvailable()) {
                dr.setAvailable(false);
                return dr;
            }
        }
        throw new NoDriverAvailableException("No drivers available");
    }

    public void bookRide(User user, double distance, FareCalculator calculator) throws NoDriverAvailableException {

        Driver driver = assignDriver();
        double fare = calculator.calculateFare(distance);
        Ride ride = new Ride(user, driver, distance, fare);
        rideHistory.add(ride);

        System.out.println("Ride booked successfully");
        ride.displayRide();
    }

    public void showRideHistory() {
        System.out.println("Ride History");
        for (Ride r : rideHistory) {
            r.displayRide();
        }
    }
}

public class CabBooking {

    public static void main(String[] args) {

        RideServices service = new RideServices();

        service.addDriver(new Driver(1, "Shaun"));
        service.addDriver(new Driver(2, "Bruce"));

        User user = new User(01, "Jhon");

        FareCalculator normalFare = new NormalFare();
        FareCalculator peakFare = new PeakFare();

        try {
            service.bookRide(user, 10, normalFare);
            service.bookRide(user, 5, peakFare);
        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }

        service.showRideHistory();
    }
}
