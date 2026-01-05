import java.util.ArrayList;
import java.util.List;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicless {

    // Encapsulated fields
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    // Constructor
    public Vehicless(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = policyNumber;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Encapsulation: getters (no direct access to policy number)
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    protected double getRentalRate() {
        return rentalRate;
    }

    // Restricted access to sensitive data
    protected String getMaskedPolicyNumber() {
        return "XXXX-" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }

    // Common display
    public void displayVehicle() {
        System.out.println("Vehicle No : " + vehicleNumber);
        System.out.println("Type       : " + type);
        System.out.println("Rate/Day   : " + rentalRate);
        System.out.println("Policy No  : " + getMaskedPolicyNumber());
    }
}

class Cars extends Vehicless implements Insurable {

    public Cars(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: 15% of daily rental rate";
    }
}

class Bike extends Vehicless implements Insurable {

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.08;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance: 8% of daily rental rate";
    }
}

class Trucks extends Vehicless implements Insurable {

    public Trucks(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 2000;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.20;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: 20% of daily rental rate";
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {

        List<Vehicless> vehicles = new ArrayList<>();

        vehicles.add(new Cars("CAR101", 3000, "POL123456"));
        vehicles.add(new Bike("BIKE202", 800, "POL654321"));
        vehicles.add(new Trucks("TRK303", 7000, "POL987654"));

        int days = 5;

        for (Vehicless v : vehicles) {

            v.displayVehicle();

            double rentalCost = v.calculateRentalCost(days);
            double insurance = 0;

            if (v instanceof Insurable) {
                Insurable i = (Insurable) v;
                insurance = i.calculateInsurance();
                System.out.println(i.getInsuranceDetails());
            }

            System.out.println("Rental Days   : " + days);
            System.out.println("Rental Cost  : " + rentalCost);
            System.out.println("Insurance    : " + insurance);
            System.out.println("Total Cost   : " + (rentalCost + insurance));
            System.out.println();
        }
    }
}
