import java.util.*;

class InsufficientBalanceExceptionn extends Exception {
    public InsufficientBalanceExceptionn(String message) {
        super(message);
    }
}

class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + " : " + amount;
    }
}

class Wallet {
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Wallet() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction("ADD", amount));
    }

    public void withdrawMoney(double amount) throws InsufficientBalanceExceptionn {
        if (balance < amount) {
            throw new InsufficientBalanceExceptionn("Insufficient balance");
        }
        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

class Userr {
    String name;
    Wallet wallet;

    Userr(String name) {
        this.name = name;
        this.wallet = new Wallet();
    }
}

interface TransferService {
    void transfer(Userr from, Userr to, double amount) throws InsufficientBalanceExceptionn;
}

class WalletTransfer implements TransferService {
    public void transfer(Userr from, Userr to, double amount) throws InsufficientBalanceExceptionn {
        from.wallet.withdrawMoney(amount);
        to.wallet.addMoney(amount);
    }
}

class BankTransfer implements TransferService {
    public void transfer(Userr from, Userr to, double amount) throws InsufficientBalanceExceptionn {
        from.wallet.withdrawMoney(amount);
        to.wallet.addMoney(amount);
    }
}

public class DigitalWallet {
    public static void main(String[] args) {

        Userr user1 = new Userr("Tony");
        Userr user2 = new Userr("Thor");

        user1.wallet.addMoney(1000);
        TransferService walletTransfer = new WalletTransfer();

        try {
            walletTransfer.transfer(user1, user2, 300);
        } catch (InsufficientBalanceExceptionn e) {
            System.out.println(e.getMessage());
        }

        System.out.println("User1 Balance: " + user1.wallet.getBalance());
        System.out.println("User2 Balance: " + user2.wallet.getBalance());
        System.out.println("User1 Transactions: " + user1.wallet.getTransactions());
    }
}
