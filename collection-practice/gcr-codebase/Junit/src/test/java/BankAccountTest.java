package Junit.src.test.java;

import Junit.src.main.java.org.example.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000.0);
    }

    @Test
    void testDeposit() {

        account.deposit(500.0);

        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void testWithdraw() {

        account.withdraw(300.0);

        assertEquals(700.0, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {

        Exception exception = assertThrows(
                IllegalStateException.class,
                () -> account.withdraw(1500.0)
        );

        assertEquals("Insufficient funds", exception.getMessage());
    }
}

