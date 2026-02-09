package Junit.src.test.java;

import static org.junit.jupiter.api.Assertions.*;

import Junit.src.main.java.org.example.Program;
import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    void Test_Deposit_ValidAmount() {
        Program account = new Program(100);
        account.deposit(50);

        assertEquals(150, account.getBalance());
    }

    @Test
    void Test_Deposit_NegativeAmount() {
        Program account = new Program(100);

        assertThrows(IllegalArgumentException.class, () -> account.deposit(-20));
    }

    @Test
    void Test_Withdraw_ValidAmount() {
        Program account = new Program(100);
        account.withdraw(40);

        assertEquals(60, account.getBalance());
    }

    @Test
    void Test_Withdraw_InsufficientFunds() {
        Program account = new Program(100);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200));
    }
}
