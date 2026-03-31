class CarRental {

    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 1500;

    CarRental(String customerName, String carModel, int rentalDays) {

        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }
//    method to calculate total cost
    double calculateTotalCost() {

        return rentalDays * costPerDay;
    }
//    method to display rental details
    void displayDetails() {

        System.out.println("Customer Name : " + customerName);
        System.out.println("Car Model     : " + carModel);
        System.out.println("Rental Days  : " + rentalDays);
        System.out.println("Total Cost   : " + calculateTotalCost());
    }

    // Main method
    public static void main(String[] args) {

        CarRental rental = new CarRental("Steve Rogers", "Tesla Cybertruck", 6);
        rental.displayDetails();
    }
}
