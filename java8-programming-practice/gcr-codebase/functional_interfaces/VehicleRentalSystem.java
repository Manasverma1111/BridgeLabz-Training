package functional_interfaces;

interface Vehicle {
    void rent();
    void returnVehicle();
}

class Car implements Vehicle {
    public void rent() {
        System.out.println("Car rented");
    }

    public void returnVehicle() {
        System.out.println("Car returned");
    }
}

class Bike implements Vehicle {
    public void rent() {
        System.out.println("Bike rented");
    }

    public void returnVehicle() {
        System.out.println("Bike returned");
    }
}

class Bus implements Vehicle {
    public void rent() {
        System.out.println("Bus rented");
    }

    public void returnVehicle() {
        System.out.println("Bus returned");
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car(),
                new Bike(),
                new Bus()
        };

        for (Vehicle v : vehicles) {
            v.rent();
            v.returnVehicle();
            System.out.println();
        }
    }
}
