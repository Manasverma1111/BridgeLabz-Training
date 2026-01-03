class Veh {
    protected int maxSpeed;
    protected String fuelType;

    Veh(int maxSpeed, String fuelType) {

        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {

        System.out.println("Max Speed : " + maxSpeed + " km/h");
        System.out.println("Fuel Type : " + fuelType);
    }
}

class Car extends Veh {
    private int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {

        super.displayInfo();
        System.out.println("Vehicle Type: Car");
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Veh {
    private double loadCapacity;

    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type: Truck");
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Veh {
    private boolean hasCarrier;

    Motorcycle(int maxSpeed, String fuelType, boolean hasCarrier) {
        super(maxSpeed, fuelType);
        this.hasCarrier = hasCarrier;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type: Motorcycle");
        System.out.println("Carrier: " + (hasCarrier ? "Yes" : "No"));
    }
}

public class VehiclenTransport {
    public static void main(String[] args) {

        Veh[] vehicles = {new Car(180, "Petrol", 5), new Truck(120, "Diesel", 10),
                new Motorcycle(150, "Petrol", true)};

        for (Veh v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}
