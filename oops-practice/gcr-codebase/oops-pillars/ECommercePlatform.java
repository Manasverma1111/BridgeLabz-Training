import java.util.ArrayList;
import java.util.List;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Products {

    private int productId;
    private String name;
    private double price;

    public Products(int productId, String name, double price) {

        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    protected double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void displayProduct() {

        System.out.println("Product ID : " + productId);
        System.out.println("Name       : " + name);
        System.out.println("Base Price : " + price);
    }
}

class Electronics extends Products implements Taxable {

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18% GST";
    }
}

class Clothing extends Products implements Taxable {

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 12% GST";
    }
}

class Groceries extends Products {

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {

    public static void printFinalPrice(List<Products> products) {

        for (Products p : products) {

            double tax = 0;

            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
                System.out.println(((Taxable) p).getTaxDetails());
            }

            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;

            p.displayProduct();
            System.out.println("Discount   : " + discount);
            System.out.println("Tax        : " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        List<Products> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 60000));
        products.add(new Clothing(102, "Jacket", 3000));
        products.add(new Groceries(103, "Rice Bag", 1200));

        printFinalPrice(products);
    }
}
