package functional_interfaces;

interface Vehicles {

    void displaySpeed();

    default void displayBatteryPercentage() {
        System.out.println("Battery information not available");
    }
}

class Cars implements Vehicles {

    public void displaySpeed() {
        System.out.println("Car speed: 80 km/h");
    }
}

class Bikes implements Vehicles {

    public void displaySpeed() {
        System.out.println("Bike speed: 60 km/h");
    }
}

class ElectricCar implements Vehicles {

    public void displaySpeed() {
        System.out.println("Electric Car speed: 90 km/h");
    }

    @Override
    public void displayBatteryPercentage() {
        System.out.println("Battery level: 75%");
    }
}

// Main class
public class SmartVehicleDashboard{

    public static void main(String[] args) {

        Vehicles[] vehicles = {
                new Cars(),
                new Bikes(),
                new ElectricCar()
        };

        for (Vehicles v : vehicles) {
            v.displaySpeed();
            v.displayBatteryPercentage();
            System.out.println();
        }
    }
}
