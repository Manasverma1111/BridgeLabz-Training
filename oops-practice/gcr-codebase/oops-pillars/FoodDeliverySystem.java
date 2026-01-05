import java.util.ArrayList;
import java.util.List;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {

    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {

        System.out.println("Item Name : " + itemName);
        System.out.println("Price : " + price);
        System.out.println("Quantity : " + quantity);
    }

    protected double getPrice() {
        return price;
    }

    protected int getQuantity() {
        return quantity;
    }
}

class VegItem extends FoodItem implements Discountable {

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied on Veg Item";
    }
}

class NonVegItem extends FoodItem implements Discountable {

    private static final double NON_VEG_CHARGE = 50.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + NON_VEG_CHARGE;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied on Non-Veg Item";
    }
}

class OrderProcessor {

    public static void processOrder(List<FoodItem> items) {

        double grandTotal = 0;

        for (FoodItem item : items) {

            item.getItemDetails();
            double total = item.calculateTotalPrice();
            System.out.println("Total Price: " + total);

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                double discount = d.applyDiscount();
                System.out.println(d.getDiscountDetails());
                total -= discount;
            }

            System.out.println("Payable Amount: " + total);
            System.out.println();

            grandTotal += total;
        }

        System.out.println("Total Order Amount: " + grandTotal);
    }
}

public class FoodDeliverySystem {

    public static void main(String[] args) {

        List<FoodItem> order = new ArrayList<>();

        FoodItem veg = new VegItem("Paneer Butter Masala", 250, 2);
        FoodItem nonVeg = new NonVegItem("Chicken Biryani", 300, 1);

        order.add(veg);
        order.add(nonVeg);

        OrderProcessor.processOrder(order);
    }
}
