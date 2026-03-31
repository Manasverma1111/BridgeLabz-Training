public class BankAccountManager {
//    bankAccount class
    static class BankAccount {

        private String accountNumber;
        private double balance;

        public BankAccount(String accountNumber, double initialBalance) {

            this.accountNumber = accountNumber;
            this.balance = (initialBalance >= 0) ? initialBalance : 0;
        }
//        method to deposit money
        public void deposit(double amount) {

            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful: " + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }
//        method to withdraw (overdraft prevention)
        public void withdraw(double amount) {

            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else if (amount > balance) {
                System.out.println("Insufficient balance. Withdrawal denied.");
            } else {
                balance -= amount;
                System.out.println("Withdrawal successful: " + amount);
            }
        }
//        method to check balance method
        public void checkBalance() {
            System.out.println("Current Balance: " + balance);
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC101", 5000);

        account.checkBalance();
        account.deposit(20000);
        account.withdraw(13000);
        account.withdraw(20000); // overdraft attempt
        account.checkBalance();
    }
}
