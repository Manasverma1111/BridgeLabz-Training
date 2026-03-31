class BankAccountss {
    protected String accountNumber;
    protected double balance;

    BankAccountss(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayBasicDetails() {

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccounts extends BankAccountss {
    private double interestRate;

    SavingsAccounts(String accountNumber, double balance, double interestRate) {

        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {

        displayBasicDetails();
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccountss {
    private double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {

        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {

        displayBasicDetails();
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccountss {
    private int tenure;
    FixedDepositAccount(String accountNumber, double balance, int tenure) {

        super(accountNumber, balance);
        this.tenure = tenure;
    }

    void displayAccountType() {

        displayBasicDetails();
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Tenure: " + tenure + " months");
    }
}

public class BankAccountTypes {
    public static void main(String[] args) {

        SavingsAccounts sa = new SavingsAccounts("SA101", 50000, 4.5);
        CheckingAccount ca = new CheckingAccount("CA202", 30000, 10000);
        FixedDepositAccount fd = new FixedDepositAccount("FD303", 200000, 24);

        sa.displayAccountType();
        System.out.println();
        ca.displayAccountType();
        System.out.println();
        fd.displayAccountType();
    }
}
