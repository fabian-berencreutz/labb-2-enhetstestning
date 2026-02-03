package se.iths.fabian.labb2enhetstestning.service;

import org.springframework.stereotype.Service;
import se.iths.fabian.labb2enhetstestning.component.AccountComponent;
import se.iths.fabian.labb2enhetstestning.exception.InsufficientFundsException;
import se.iths.fabian.labb2enhetstestning.exception.InvalidAmountException;
import se.iths.fabian.labb2enhetstestning.exception.MaxWithdrawalExceededException;

@Service
public class ATMService {
    private final AccountComponent accountComponent;
    private static final int MAX_WITHDRAWAL = 500;

    public ATMService(AccountComponent accountComponent) {
        this.accountComponent = accountComponent;
    }

    public void performDepositMoney(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Beloppet måste vara större än 0.");
        }
        accountComponent.depositMoney(amount);
    }

    public void performWithdrawMoney(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Beloppet måste vara större än 0.");
        }
        if (amount > MAX_WITHDRAWAL) {
            throw new MaxWithdrawalExceededException("För stort belopp per uttag.");
        }
        if (amount > accountComponent.getBalance()) {
            throw new InsufficientFundsException("Du har inte så mycket pengar.");
        }
        accountComponent.withdrawMoney(amount);
    }

    public int performGetBalance() {
        return accountComponent.getBalance();
    }
}
