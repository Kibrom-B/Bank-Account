package bank.account;

public class Account {
    private String accountNumber;
    private String accountType;
    private double accountBalance;

    public Account(String accountNumber, String accountType, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposit successful. New balance: " + accountBalance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal successful. New balance: " + accountBalance);
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public void checkAccountBalance() {
        System.out.println("Current balance: " + accountBalance);
    }
}
