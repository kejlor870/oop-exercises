package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    // Arrange
    @BeforeEach
    void setUpAccount(){
        account = new BankAccount("Jan");
    }

    @Test
    void testInitialBalanceIsZero(){
        // BeforeEach Arrange

        // Act
        double acctualBalance = account.getBalance();

        // Assert
        assertEquals(0.0, acctualBalance, 0.001);
    }

    @Test
    void testDepositPositiveAmount(){
        // Arrange
        double amountToDeposit = 200.33;

        // Act
        boolean result = account.deposit(amountToDeposit);

        // Arrange
        assertTrue(result); // Method returns true / false
        assertEquals(200.33, account.getBalance(), 0.001);
    }

    @Test
    void testDepositNegativeAmount(){
        // Arange
        double amountToDeposit = -50.0;

        // Act
        boolean result = account.deposit(amountToDeposit);

        // Assert
        assertFalse(result);
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawPositiveAmountWithinBalance(){
        // Arange
        account.deposit(200.33);
        double amountToWithdraw = 50.0;

        // Act
        boolean result = account.withdraw(amountToWithdraw);

        // Assert
        assertTrue(result);
        assertEquals(150.33, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawMoreThanBalance(){
        // Arange
        account.deposit(200.33);
        double amountToWithdraw = 300.0;

        // Act
        boolean result = account.withdraw(amountToWithdraw);

        // Assert
        assertFalse(result);
        assertEquals(200.33, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawNegativeAmount() {
        // Arrange
        account.deposit(200.33);
        double amountToDeposit = -10.0;

        // Act
        boolean result = account.withdraw(amountToDeposit);

        // Assert
        assertFalse(result);
        assertEquals(200.33, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawExactBalance() {
        // Arrange
        account.deposit(100.0);
        double exactAmount = 100.0;

        // Act
        boolean result = account.withdraw(exactAmount);

        // Assert
        assertTrue(result);
        assertEquals(0.0, account.getBalance(), 0.001);
    }

}
