class Vehicle {

    String ownerName;
    String vehicleType;

    static double registrationFee = 5000;

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails() {

        System.out.println("Owner Name        : " + ownerName);
        System.out.println("Vehicle Type     : " + vehicleType);
        System.out.println("Registration Fee : " + registrationFee);
    }

    static void updateRegistrationFee(double newFee) {

        registrationFee = newFee;
    }

    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("Steve Rogers", "Car");
        Vehicle v2 = new Vehicle("Bruce Banner", "Bike");

        v1.displayVehicleDetails();
        System.out.println();
        Vehicle.updateRegistrationFee(7500);
        System.out.println();
        v2.displayVehicleDetails();
    }
}
