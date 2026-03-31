package functional_interfaces;

interface Sensitive {
}

class BankAccount implements Sensitive {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{accountNumber='****', balance=****}";
    }
}

class Products {
    private String name;

    public Products(String name) {
        this.name = name;
    }
}

class EncryptionUtil {

    public static void encryptIfRequired(Object obj) {

        if (obj instanceof Sensitive) {
            System.out.println("Encrypting sensitive data: " + obj);
        } else {
            System.out.println("No encryption needed for this object");
        }
    }
}

public class SensitiveDataTracking {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("1234567890", 50000);
        Products product = new Products("Laptop");

        EncryptionUtil.encryptIfRequired(account);
        EncryptionUtil.encryptIfRequired(product);
    }
}

