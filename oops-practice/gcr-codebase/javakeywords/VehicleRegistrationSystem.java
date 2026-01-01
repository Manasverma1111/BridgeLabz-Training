class Vehicles {

    static double registrationFee = 150.0;

    final String registrationNumber;

    String ownerName;
    String vehicleType;

    Vehicles(String ownerName, String vehicleType, String registrationNumber) {

        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double newFee) {

        registrationFee = newFee;
    }

    // 4. instanceof check before displaying details
    void displayDetails(Object obj) {
        if (obj instanceof Vehicles) {
            Vehicles v = (Vehicles) obj;
            System.out.println("Owner Name: " + v.ownerName);
            System.out.println("Vehicle Type: " + v.vehicleType);
            System.out.println("Registration Number: " + v.registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {

        Vehicles v1 = new Vehicles("Honest raj", "Sedan", "ABC123");
        Vehicles v2 = new Vehicles("Price danish", "SUV", "XYZ789");

        v1.displayDetails(v1);
        v2.displayDetails(v2);
    }
}
