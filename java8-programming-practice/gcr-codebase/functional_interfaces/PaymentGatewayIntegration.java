package functional_interfaces;

interface PaymentProcessor {

    void pay(double amount);

    default void refund(double amount) {
        System.out.println("Refund of " + amount + " processed using standard flow");
    }
}

class UpiProcessor implements PaymentProcessor {

    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI");
    }
}

class CreditCardProcessor implements PaymentProcessor {

    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund of " + amount + " processed to Credit Card");
    }
}

public class PaymentGatewayIntegration {

    public static void main(String[] args) {

        PaymentProcessor upi = new UpiProcessor();
        PaymentProcessor card = new CreditCardProcessor();

        upi.pay(1000);
        upi.refund(200);

        System.out.println();

        card.pay(1500);
        card.refund(300);
    }
}
