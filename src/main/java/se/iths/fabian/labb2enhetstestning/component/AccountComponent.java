package se.iths.fabian.labb2enhetstestning.component;

import org.springframework.stereotype.Component;

@Component
public class AccountComponent {
    private int balance = 0;

    public void withdrawMoney(int amount) {
        balance -= amount;
    }

    public void depositMoney(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
