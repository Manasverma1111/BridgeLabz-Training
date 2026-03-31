import java.util.*;

// Interface
interface IRentable {
    double calculateRent(int days);
}

// Base class
abstract class Vehiccle implements IRentable {
    protected int vehicleId;
    protected String brand;
    protected double ratePerDay;

    Vehiccle(int vehicleId, String brand, double ratePerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.ratePerDay = ratePerDay;
    }

    abstract void displayDetails();
}

// Inheritance
class Bikke extends Vehiccle {
    Bikke(int vehicleId, String brand, double ratePerDay) {
        super(vehicleId, brand, ratePerDay);
    }

    public double calculateRent(int days) {
        return days * ratePerDay;
    }

    void displayDetails() {
        System.out.println("Bike | ID: " + vehicleId + ", Brand: " + brand + ", Rate/Day: " + ratePerDay);
    }
}

class Carrs extends Vehiccle {
    Carrs(int vehicleId, String brand, double ratePerDay) {
        super(vehicleId, brand, ratePerDay);
    }

    public double calculateRent(int days) {
        return days * ratePerDay;
    }

    void displayDetails() {
        System.out.println("Car | ID: " + vehicleId + ", Brand: " + brand + ", Rate/Day: " + ratePerDay);
    }
}

class Truckk extends Vehiccle {
    Truckk(int vehicleId, String brand, double ratePerDay) {
        super(vehicleId, brand, ratePerDay);
    }

    public double calculateRent(int days) {
        return days * ratePerDay;
    }

    void displayDetails() {
        System.out.println("Truck | ID: " + vehicleId + ", Brand: " + brand + ", Rate/Day: " + ratePerDay);
    }
}

class Customer {
    int customerId;
    String name;

    Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }
}

public class VehicleRentalApp {

    public static void main(String[] args) {
//        Create Objects
        Vehiccle bike = new Bikke(101, "Yamaha", 500);
        Vehiccle car = new Carrs(102, "Honda", 1500);
        Vehiccle truck = new Truckk(103, "Tata", 3000);

        Customer customer = new Customer(1, "Amit");
//        Store Objects
        List<Vehiccle> vehicles = new ArrayList<>();
        vehicles.add(bike);
        vehicles.add(car);
        vehicles.add(truck);
//        Read the Details
        System.out.println("Available Vehicles:");
        for (Vehiccle v : vehicles) {
            v.displayDetails(); // Polymorphism
        }
//        Update
        car.ratePerDay = 1800;
//        Calculate Rent
        System.out.println("\nRent for " + customer.name + ":");
        System.out.println("Bike (2 days): " + bike.calculateRent(2));
        System.out.println("Car (3 days): " + car.calculateRent(3));
        System.out.println("Truck (1 day): " + truck.calculateRent(1));
//        Delete
        vehicles.remove(truck);
//        Display final
        System.out.println("\nVehicles after deletion:");
        for (Vehiccle v : vehicles) {
            v.displayDetails();
        }
    }
}
