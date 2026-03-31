package functional_interfaces;

interface Payment {
    void pay(double amount);
}

class UPI implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class CreditCard implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class Wallet implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Wallet");
    }
}

public class DigitalPayment {
    public static void main(String[] args) {

        Payment[] payments = {
                new UPI(),
                new CreditCard(),
                new Wallet()
        };

        for (Payment p : payments) {
            p.pay(500.00);
        }
    }
}
