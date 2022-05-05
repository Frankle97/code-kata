package account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    Account account;

    @BeforeEach
    public void before() {
        account = new Account(10000);
    }

    @Test
    public void existsAccount() {
        Assertions.assertNotNull(account);
    }

    @Test
    public void getBalance() {
        Account account1 = new Account(10000);
        assertEquals(10000, account1.getBalance());
        Account account2 = new Account(1000);
        assertEquals(1000, account2.getBalance());
        Account account3 = new Account(0);
        assertEquals(0, account3.getBalance());
    }

    @Test
    public void deposit() {
        Account account = new Account(10000);
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }


    @Test
    public void withdraw() {
        Account account = new Account(10000);
        account.withdraw(1000);
        assertEquals(9000, account.getBalance());
    }
}
