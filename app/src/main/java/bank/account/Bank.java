package bank.account;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public void openNewAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account created successfully: " + account.getAccountNumber());
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void closeAccount(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null && account.getAccountBalance() == 0) {
            accounts.remove(accountNumber);
            System.out.println("Account closed successfully: " + accountNumber);
        } else {
            throw new IllegalArgumentException("Cannot close account with remaining balance");
        }
    }
}
