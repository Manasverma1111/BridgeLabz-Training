package future_logistics;

public class TimberTransport extends GoodsTransport {

    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String id, String date, int rating, float length, float radius, String type, float price) {
        super(id, date, rating);
        this.timberLength = length;
        this.timberRadius = radius;
        this.timberType = type;
        this.timberPrice = price;
    }

    public String vehicleSelection() {

        float area = 2 * 3.147f * timberRadius * timberLength;
        if (area < 250) {
            return "Truck";
        }
        if (area <= 400) {
            return "Lorry";
        }

        return "MonsterLorry";
    }

    public float calculateTotalCharge() {

        float volume = 2.147f * timberLength * timberRadius * timberPrice;
        float rate = timberType.equalsIgnoreCase("Premium") ? 0.25f : 0.15f;
        float price = volume * timberPrice * rate;
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
            return 0.10f;
        }

        return 0;
    }
}
