class Productt {

    // 1. Static members
    static double discount = 10.0; // percentage

    // 3. Final variable
    final String productID;

    // Instance variables
    String productName;
    double price;
    int quantity;

    Productt(String productID, String productName, double price, int quantity) {

        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void updateDiscount(double newDiscount) {

        discount = newDiscount;
    }

    double getPriceAfterDiscount() {

        return price - (price * discount / 100);
    }

    // 4. instanceof check before displaying details
    void displayDetails(Object obj) {

        if (obj instanceof Productt) {
            Productt p = (Productt) obj;
            System.out.println("Product ID: " + p.productID);
            System.out.println("Product Name: " + p.productName);
            System.out.println("Price: $" + p.price);
            System.out.println("Quantity: " + p.quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price after Discount: $" + p.getPriceAfterDiscount());
            System.out.println();
        }
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {

        Productt p1 = new Productt("P001", "Laptop", 1200.0, 5);
        Productt p2 = new Productt("P002", "Smartphone", 800.0, 10);

        Productt.updateDiscount(10.0);
        p1.displayDetails(p1);
        p2.displayDetails(p2);
    }
}
