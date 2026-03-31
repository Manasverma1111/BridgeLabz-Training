import java.util.ArrayList;
import java.util.List;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicleess {

    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicleess(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID : " + vehicleId);
        System.out.println("Driver     : " + driverName);
        System.out.println("Rate/Km    : " + ratePerKm);
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }
}

class Carr extends Vehicleess implements GPS {

    private String location;

    public Carr(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

class Bikes extends Vehicleess implements GPS {

    private String location;

    public Bikes(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.8;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

class Auto extends Vehicleess implements GPS {

    private String location;

    public Auto(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return (distance * getRatePerKm()) + 20;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

class RideService {

    public static void calculateRideFare(List<Vehicleess> vehicles, double distance) {

        for (Vehicleess v : vehicles) {

            v.getVehicleDetails();
            System.out.println("Distance : " + distance + " km");
            System.out.println("Fare : " + v.calculateFare(distance));

            if (v instanceof GPS) {
                System.out.println("Location : " + ((GPS) v).getCurrentLocation());
            }

            System.out.println();
        }
    }
}

public class RideHailingApp {

    public static void main(String[] args) {

        List<Vehicleess> vehicles = new ArrayList<>();

        Vehicleess car = new Carr(1, "Ramesh", 15);
        Vehicleess bike = new Bikes(2, "Suresh", 10);
        Vehicleess auto = new Auto(3, "Lakhan", 12);

        ((GPS) car).updateLocation("MG Road");
        ((GPS) bike).updateLocation("City Center");
        ((GPS) auto).updateLocation("Bus Stand");

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(auto);

        RideService.calculateRideFare(vehicles, 8);
    }
}
