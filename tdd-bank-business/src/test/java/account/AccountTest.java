package account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void existsAccount() {
        Account account = new Account(0);
    }

    @Test
    public void getBalance() {
        Account account1 = new Account(10000);
        Assertions.assertEquals(10000, account1.getBalance());
        Account account2 = new Account(1000);
        Assertions.assertEquals(1000, account2.getBalance());
        Account account3 = new Account(0);
        Assertions.assertEquals(0, account3.getBalance());
    }
}
