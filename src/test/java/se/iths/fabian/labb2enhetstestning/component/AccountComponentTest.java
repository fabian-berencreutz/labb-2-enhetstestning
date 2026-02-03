package se.iths.fabian.labb2enhetstestning.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComponentTest {
    private AccountComponent accountComponent;

    @BeforeEach
    void setUp() {
        accountComponent = new AccountComponent();
    }

    @Test
    public void testDepositAndWithdrawMoney() {
        accountComponent.depositMoney(1000);
        accountComponent.withdrawMoney(500);

        assertEquals(500, accountComponent.getBalance());
    }

    @Test
    public void testWithdrawMoney() {
        accountComponent.withdrawMoney(250);

        assertEquals(-250, accountComponent.getBalance());
    }

    @Test
    public void testDepositMoney() {
        accountComponent.depositMoney(500);

        assertEquals(500, accountComponent.getBalance());
    }

    @Test
    public void testGetBalance() {
        assertEquals(0, accountComponent.getBalance());
    }
}
