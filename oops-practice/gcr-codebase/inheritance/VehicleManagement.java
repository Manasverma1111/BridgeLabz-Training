interface Refuelable {
    void refuel();
}

// Superclass
class Vehiclee {
    protected String model;
    protected int maxSpeed;

    Vehiclee(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void displayVehicleInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehiclee {

    ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    void charge() {
        displayVehicleInfo();
        System.out.println("Vehicle Type: Electric Vehicle");
        System.out.println("Action: Charging battery");
    }
}

class PetrolVehicle extends Vehiclee implements Refuelable {

    PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    @Override
    public void refuel() {

        displayVehicleInfo();
        System.out.println("Vehicle Type: Petrol Vehicle");
        System.out.println("Action: Refueling with petrol");
    }
}

public class VehicleManagement {
    public static void main(String[] args) {

        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 225);
        Refuelable pv = new PetrolVehicle("Honda City", 180);
        ev.charge();
        System.out.println();

        pv.refuel();
    }
}
