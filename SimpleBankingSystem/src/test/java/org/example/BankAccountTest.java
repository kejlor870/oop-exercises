package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    // ############## Transactions history tests ##############

    @Test
    void testDepositCreatesCorrectTransactionObject(){
        // Arange
        double depositAmount = 200.33;

        // Act
        account.deposit(depositAmount); // Deposit amount
        List<Transaction> history = account.getTransactionHistory(); // Get account transaction history List

        Transaction firstTransaction = history.getFirst(); // Get first transaction object

        // Assert
        assertEquals(1, history.size());    // Saved 1 transaction in history
        assertEquals(TransactionType.DEPOSIT, firstTransaction.getType());  // Saved transactionType is DEPOSIT
        assertEquals(200.33, firstTransaction.getAmount(), 0.001);  // Saved transaction amount equals provided
    }

    @Test
    void testWithdrawCreatesCorrectTransactionObject(){
        // Arange
        account.deposit(200.33);    // First transaction - DEPOSIT
        double amountToWithdraw = 50.0;

        // Act
        account.withdraw(amountToWithdraw); // Second transaction - WITHDRAW
        List<Transaction> history = account.getTransactionHistory();

        Transaction secondTransaction = history.get(1);

        // Assert
        assertEquals(2, history.size());
        assertEquals(TransactionType.WITHDRAW, secondTransaction.getType());
        assertEquals(50.0, secondTransaction.getAmount(), 0.001);
    }

}
