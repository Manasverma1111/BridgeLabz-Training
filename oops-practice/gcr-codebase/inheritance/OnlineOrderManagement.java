class Order {
    protected int orderId;
    protected String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered";
    }
}

public class OnlineOrderManagement {
    public static void main(String[] args) {
        DeliveredOrder order = new DeliveredOrder(1001, "2025-01-05", "TRK789456", "2025-01-08");

        System.out.println("Order ID: " + order.orderId);
        System.out.println("Order Date: " + order.orderDate);
        System.out.println("Tracking No.: " + order.trackingNumber);
        System.out.println("Delivery Date: " + order.getOrderStatus());
        System.out.println("Order Status: " + order.getOrderStatus());
    }
}
