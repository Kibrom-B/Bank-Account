package bank.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
  private Bank bank;
  private Account account1;
  private Account account2;

  @BeforeEach
  public void setUp() {
    bank = new Bank();
    account1 = new Account("123", "checking", 1000.0);
    account2 = new Account("456", "savings", 2000.0);
    bank.openNewAccount(account1);
    bank.openNewAccount(account2);
  }

  @Test
  public void testGetAllAccounts() {
    assertEquals(2, bank.getAllAccounts().size());
  }

  @Test
  public void testOpenNewAccount() {
    Account account3 = new Account("789", "checking", 3000.0);
    bank.openNewAccount(account3);
    assertEquals(3, bank.getAllAccounts().size());
  }

  @Test
  public void testGetAccount() {
    Account foundAccount = bank.getAccount("123");
    assertEquals(account1, foundAccount);
  }

  @Test
  public void testCloseAccountWithRemainingBalance() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      bank.closeAccount("123");
    });
    assertEquals("Cannot close account with remaining balance", exception.getMessage());
  }
}
