package se.iths.fabian.labb2enhetstestning.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.fabian.labb2enhetstestning.component.AccountComponent;
import se.iths.fabian.labb2enhetstestning.exception.InsufficientFundsException;
import se.iths.fabian.labb2enhetstestning.exception.InvalidAmountException;
import se.iths.fabian.labb2enhetstestning.exception.MaxWithdrawalExceededException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {
    @Mock
    AccountComponent accountComponent;

    @InjectMocks
    ATMService atmService;

    @Test
    public void testInvalidAmountExceptionIsThrown() {
        assertThrows(InvalidAmountException.class, () -> {
            atmService.performDepositMoney(0);
        });
        assertThrows(InvalidAmountException.class, () -> {
            atmService.performWithdrawMoney(0);
        });
    }

    @Test
    public void testMaxWithdrawalExceededExceptionIsThrown() {
        assertThrows(MaxWithdrawalExceededException.class, () -> {
           atmService.performWithdrawMoney(1000);
        });
    }

    @Test
    public void testInsufficientFundsExceptionIsThrown() {
        when(accountComponent.getBalance()).thenReturn(50);
        assertThrows(InsufficientFundsException.class, () -> {
            atmService.performWithdrawMoney(100);
        });
    }

    @Test
    public void testPerformDepositMoney() {
        atmService.performDepositMoney(500);
        verify(accountComponent).depositMoney(500);
    }

    @Test
    public void testPerformWithdrawMoney() {
        when(accountComponent.getBalance()).thenReturn(1000);

        atmService.performWithdrawMoney(500);

        verify(accountComponent).withdrawMoney(500);
    }

    @Test
    public void testReturnBalance() {
        when(accountComponent.getBalance()).thenReturn(100);
        int result = atmService.performGetBalance();
        assertEquals(100, result);
        verify(accountComponent).getBalance();
    }
}
