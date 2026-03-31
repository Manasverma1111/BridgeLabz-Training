package future_logistics;

public class BrickTransport extends GoodsTransport {

    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String id, String date, int rating, float size, int quantity, float price) {

        super(id, date, rating);
        this.brickSize = size;
        this.brickQuantity = quantity;
        this.brickPrice = price;
    }

    public String vehicleSelection() {

        if (brickQuantity < 300) {
            return "Truck";
        }
        if (brickQuantity <= 500) {
            return "Lorry";
        }

        return "MonsterLorry";
    }

    public float calculateTotalCharge() {

        float price = brickPrice * brickQuantity;
        float tax = price * 0.3f;
        float discount = getDiscount(price);

        return price + tax + getVehicleCost() - discount;
    }

    private float getVehicleCost() {

        return switch (vehicleSelection()) {
            case "Truck" -> 1000;
            case "Lorry" -> 1700;
            default -> 3000;
        };

    }

    private float getDiscount(float price) {

        if (transportRating == 5) {
            return price * 0.20f;
        }
        if (transportRating >= 3) {
            return price * 0.10f;
        }

        return 0;
    }
}
