package multithreading;
import java.time.LocalTime;

class BankAccount {
    private int balance = 10000;

    public void withdraw(String customer, int amount) {
        System.out.println("[" + customer + "] Attempting to withdraw " + amount);

        if (balance >= amount) {
            balance -= amount;
            System.out.println("Transaction successful: " + customer + ", Amount: " + amount + ", Balance: " + balance + ", Time: " + LocalTime.now());
        } else {
            System.out.println("Transaction failed: " + customer + ", Insufficient balance");
        }
    }
}

class Transaction implements Runnable {
    private BankAccount account;
    private int amount;
    private String customer;

    public Transaction(BankAccount account, String customer, int amount) {
        this.account = account;
        this.customer = customer;
        this.amount = amount;
    }

    public void run() {
        System.out.println(customer + " thread state: " + Thread.currentThread().getState());
        account.withdraw(customer, amount);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new Transaction(account, "Customer-1", 3000));
        Thread t2 = new Thread(new Transaction(account, "Customer-2", 4000));
        Thread t3 = new Thread(new Transaction(account, "Customer-3", 2000));
        Thread t4 = new Thread(new Transaction(account, "Customer-4", 5000));
        Thread t5 = new Thread(new Transaction(account, "Customer-5", 1500));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}