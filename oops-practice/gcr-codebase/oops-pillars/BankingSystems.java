import java.util.ArrayList;
import java.util.List;

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankkAccount {

    private String accountNumber;
    private String holderName;
    private double balance;

    public BankkAccount(String accountNumber, String holderName, double balance) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public abstract double calculateInterest();

    public String getAccountNumber() {
        return "XXXX" + accountNumber.substring(accountNumber.length() - 4);
    }

    public String getHolderName() {
        return holderName;
    }

    protected double getBalance() {
        return balance;
    }

    public void displayAccount() {

        System.out.println("Account No : " + getAccountNumber());
        System.out.println("Holder    : " + holderName);
        System.out.println("Balance   : " + balance);
    }
}

class SavingsAccountss extends BankkAccount implements Loanable {

    private static final double INTEREST_RATE = 0.04;
    private double loanAmount;

    public SavingsAccountss(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        loanAmount = amount;
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= loanAmount * 0.5;
    }
}

class CurrentAccount extends BankkAccount implements Loanable {

    private static final double INTEREST_RATE = 0.01;
    private double loanAmount;

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        loanAmount = amount;
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= loanAmount * 0.7;
    }
}

public class BankingSystems {

    public static void main(String[] args) {

        List<BankkAccount> accounts = new ArrayList<>();

        BankkAccount acc1 = new SavingsAccountss("SB12345678", "Alice", 50000);
        BankkAccount acc2 = new CurrentAccount("CA87654321", "Bob", 80000);

        accounts.add(acc1);
        accounts.add(acc2);

        for (BankkAccount acc : accounts) {

            acc.displayAccount();

            double interest = acc.calculateInterest();
            System.out.println("Interest   : " + interest);

            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(40000);

                System.out.println("Loan Status: " + (loanAcc.calculateLoanEligibility() ? "Eligible" : "Not Eligible"));
            }

            System.out.println();
        }
    }
}
