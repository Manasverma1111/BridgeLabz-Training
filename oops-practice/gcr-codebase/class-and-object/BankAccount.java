class BankAccount {

    String accountHolder;
    String accountNumber;
    double balance;
//    method to display current balance
    void displayBalance() {

        System.out.println("Current balance: " + balance);
    }
//    method to deposit money
    void deposit(double amount) {

        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }
//    method to withdraw money
    void withdraw(double amount) {

        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdraw amount is : " + amount);
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount();
//        initial details
        account.accountHolder = "State of Chennai";
        account.accountNumber = "ACC001";
        account.balance = 700.0;

        System.out.println(account.accountHolder);
        account.displayBalance();
//        deposit operation
        account.deposit(200.0);
//        withdraw operations
        account.withdraw(100.0);
        account.withdraw(1000.0); // insufficient balance
    }
}

