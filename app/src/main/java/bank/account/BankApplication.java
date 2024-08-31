
package bank.account;

import java.util.Scanner;

public class BankApplication {
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        // Create initial accounts
        Account account1 = new Account("12345", "checking", 1000);
        Account account2 = new Account("67890", "savings", 5000);

        // Add accounts to the bank
        bank.openNewAccount(account1);
        bank.openNewAccount(account2);

        // User interface
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nWelcome to the Banking Application");
            System.out.println("1. Display all accounts");
            System.out.println("2. Make a deposit");
            System.out.println("3. Make a withdrawal");
            System.out.println("4. Check account balance");
            System.out.println("5. Close an account");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAllAccounts();
                    break;
                case 2:
                    makeDeposit(scanner);
                    break;
                case 3:
                    makeWithdrawal(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    closeAccount(scanner);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayAllAccounts() {
        for (Account account : bank.getAllAccounts()) {
            System.out.println("Account Number: " + account.getAccountNumber() +
                    ", Type: " + account.getAccountType() +
                    ", Balance: " + account.getAccountBalance());
        }
    }

    private static void makeDeposit(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        Account account = bank.getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void makeWithdrawal(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        Account account = bank.getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();

        Account account = bank.getAccount(accountNumber);
        if (account != null) {
            account.checkAccountBalance();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void closeAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();

        bank.closeAccount(accountNumber);
    }
}