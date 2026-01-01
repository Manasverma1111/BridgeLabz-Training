class BankAccountts {

    static String bankName = "State Bank of India";
    static int totalAccounts = 0;
    final String accountNumber;
    String accountHolder;
    double balance;

    BankAccountts(String accountHolder, String accountNumber, double balance) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }
//    deposit method
    void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
//    withdraw method
    void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\nWithdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
//    display details using instanceof
    void displayDetails(Object obj) {

        if (obj instanceof BankAccount) {
            BankAccount acc = (BankAccount) obj;
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + acc.accountHolder);
            System.out.println("Account Number: " + acc.accountNumber);
            System.out.println("Balance: $" + acc.balance);
        }
    }

    static void getTotalAccounts() {

        System.out.println("Total number of accounts: " + totalAccounts);
    }
}

public class BankAccountt {
    public static void main(String[] args) {

        BankAccountts acc1 = new BankAccountts("Lynda Princy", "ACC12345", 1000.0);
        BankAccountts acc2 = new BankAccountts("Prince Danish", "ACC67890", 500.0);

        System.out.println("Account 1 Details:");
        acc1.displayDetails(acc1);
        System.out.println("\nAccount 2 Details:");
        acc2.displayDetails(acc2);

        BankAccountts.getTotalAccounts();

        System.out.println("\nPerforming transactions on Account 1:");
        acc1.deposit(200.0);
        acc1.withdraw(150.0);
        acc1.displayDetails(acc1);

        acc2.displayDetails(acc2);
        acc2.deposit(100.0);
        acc2.withdraw(700.0);
    }
}
