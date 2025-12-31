class BankAccounts {

    public String accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccounts(String accountNumber, String accountHolder, double balance) {

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        setBalance(balance);   // Use setter
    }

    // Public getter for balance
    public double getBalance() {
        return balance;
    }

    // Public setter for balance
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative");
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw method
    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
//    display basic account details
    void displayAccountDetails() {

        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : ₹" + balance);
    }
}

// Child class
class SavingsAccount extends BankAccounts {

    double interestRate;

    // Constructor
    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {

        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }
//    method demonstrating access to public and protected members
    void displaySavingsAccountDetails() {

        System.out.println("Savings Account Details");
        System.out.println("Account Number : " + accountNumber);     // public
        System.out.println("Account Holder : " + accountHolder);     // protected
        System.out.println("Balance        : ₹" + getBalance());     // private via getter
        System.out.println("Interest Rate  : " + interestRate + "%");
    }
}

// Main class
public class BankAccountManagement {

    public static void main(String[] args) {

        SavingsAccount sa = new SavingsAccount("SB12345", "Manas Verma", 10000, 4.5);

        sa.displayAccountDetails();
        System.out.println();
        sa.deposit(5000);
        sa.withdraw(2000);

        sa.displaySavingsAccountDetails();
    }
}
