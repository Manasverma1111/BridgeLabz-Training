import java.util.ArrayList;
import java.util.List;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    double calculateInterest();
}

abstract class Account implements BankService {

    protected int accountNumber;
    protected String holderName;
    protected double balance;
    protected List<String> transactionHistory = new ArrayList<>();

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        transactionHistory.add("Account created: " + balance);
    }

    public synchronized void deposit(double amount) {

        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {

        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: " + amount);
    }

    public synchronized void transfer(Account target, double amount) throws InsufficientBalanceException {

        this.withdraw(amount);
        target.deposit(amount);
        transactionHistory.add("Transferred " + amount + " to Account " + target.accountNumber);
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactionHistory() {

        System.out.println("Transaction History for Account " + accountNumber);
        for (String t : transactionHistory) {
            System.out.println(t);
        }
        System.out.println();
    }
}

class SavingsAccountt extends Account {

    public SavingsAccountt(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccountt extends Account {

    public CurrentAccountt(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.02;
    }
}

class TransactionTask extends Thread {

    private Account account;
    private double amount;
    private boolean isDeposit;

    public TransactionTask(Account account, double amount, boolean isDeposit) {

        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {
        try {
            if (isDeposit) {
                account.deposit(amount);
                System.out.println("Deposit successful: " + amount);
            } else {
                account.withdraw(amount);
                System.out.println("Withdrawal successful: " + amount);
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class OnlineBankingSystem {

    public static void main(String[] args) {

        Account acc1 = new SavingsAccountt(101, "Jack", 5000);
        Account acc2 = new CurrentAccountt(102, "Natasha", 3000);

        Thread t1 = new TransactionTask(acc1, 1000, true);
        Thread t2 = new TransactionTask(acc1, 2000, false);
        Thread t3 = new TransactionTask(acc1, 500, true);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();

            acc1.transfer(acc2, 1000);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Final Balance Savings: " + acc1.getBalance());
        System.out.println("Final Balance Current: " + acc2.getBalance());
        System.out.println("Savings Interest: " + acc1.calculateInterest());
        System.out.println("Current Interest: " + acc2.calculateInterest());

        acc1.showTransactionHistory();
        acc2.showTransactionHistory();
    }
}
