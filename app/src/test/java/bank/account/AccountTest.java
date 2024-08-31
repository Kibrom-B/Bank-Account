package bank.account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("123", "checking", 1000.0);
    }

    @Test
    public void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getAccountBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(400.0);
        assertEquals(600.0, account.getAccountBalance());
    }

    @Test
    public void testCheckAccountBalance() {
        assertEquals(1000.0, account.getAccountBalance());
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1500.0);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }
}
