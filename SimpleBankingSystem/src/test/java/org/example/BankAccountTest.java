package org.example;

import org.example.model.BankAccount;
import org.example.model.Transaction;
import org.example.model.TransactionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
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

    @Test
    void testConstructorRejectsBlankOwner(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount("   ")
        );
    }

    @Test
    void testRejectDepositZero(){
        // Arange
        double depositAmount = 0.0;

        // Act
        boolean result = account.deposit(depositAmount);

        // Assert
        assertFalse(result);
    }

    @Test
    void testRejectWithdrawZero(){
        // Arange
        double withdrawAmount = 0;

        // Act
        boolean result = account.withdraw(withdrawAmount);

        // Assert
        assertFalse(result);
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

    @Test
    void testNewAccountHaveEmptyTransactionHistory(){
        // Arange

        // Act
        List<Transaction> history = account.getTransactionHistory();

        // Assert
        assertEquals(0, history.size());
    }

    @Test
    void testHistoryUnchangedAfterFailDeposit(){
        // Arange
        double amountToDeposit = -10.0;
        account.deposit(amountToDeposit);

        // Act
        List<Transaction> history = account.getTransactionHistory();

        // Assert
        assertEquals(0, history.size());
    }

    @Test
    void testHistoryUnchangedAfterFailWithdrawal(){
        // Arange
        double amountToWithdraw = -10.0;
        account.deposit(amountToWithdraw);

        // Act
        List<Transaction> history = account.getTransactionHistory();

        // Assert
        assertEquals(0, history.size());
    }

    @Test
    void testTransactionTime(){
        // Arange
        double depositAmount = 50.0;
        account.deposit(depositAmount);

        // Act
        List<Transaction> history = account.getTransactionHistory();
        Transaction depositTransaction = history.getFirst();

        LocalDateTime transactionTime = depositTransaction.getTime();

        // Assert
        assertInstanceOf(LocalDateTime.class, transactionTime);
    }

    // ############## Transfer tests ##############

    @Test
    void testTransferFromAtoB(){
        // Arange
        BankAccount account2 = new BankAccount("Ola");
        account.deposit(200.0);

        // Act
        boolean result = account.transferTo(account2, 100.0);

        // Assert
        assertTrue(result);
        assertEquals(100.0, account.getBalance());
        assertEquals(100.0, account2.getBalance());
    }

    @Test
    void testTransferMoreThanBalance(){
        // Arange
        BankAccount account2 = new BankAccount("Ola");
        account.deposit(200.0);

        // Act
        boolean result = account.transferTo(account2, 300.0);

        List<Transaction> historyAcc = account.getTransactionHistory();
        List<Transaction> historyAcc2 = account2.getTransactionHistory();

        // Assert
        assertFalse(result);
        assertEquals(200.0, account.getBalance());
        assertEquals(0.0, account2.getBalance());
        assertEquals(1, historyAcc.size()); // 1 - deposit, none transfer_out
        assertEquals(0, historyAcc2.size()); // 0 - transactions, none deposit/transfer_in
    }

    @Test
    void testTransferNegativeAmount(){
        // Arange
        BankAccount account2 = new BankAccount("Ola");
        account.deposit(200.0);

        // Act
        boolean result = account.transferTo(account2, -100.0);

        List<Transaction> historyAcc = account.getTransactionHistory();
        List<Transaction> historyAcc2 = account2.getTransactionHistory();

        // Assert
        assertFalse(result);
        assertEquals(200.0, account.getBalance());
        assertEquals(0.0, account2.getBalance());
        assertEquals(1, historyAcc.size()); // 1 - deposit, none transfer_out
        assertEquals(0, historyAcc2.size()); // 0 - transactions, none deposit/transfer_in
    }

    @Test
    void testTransferToNull(){
        // Arange
        account.deposit(200.0);

        // Act
        boolean result = account.transferTo(null, 100.0);

        List<Transaction> historyAcc = account.getTransactionHistory();

        // Assert
        assertFalse(result);
        assertEquals(200.0, account.getBalance());
        assertEquals(1, historyAcc.size()); // 1 - deposit, none transfer_out
    }

    @Test
    void testTransferSavesToHistory(){
        // Arange
        BankAccount account2 = new BankAccount("Ola");
        account.deposit(200.0);

        // Act
        boolean result = account.transferTo(account2, 100.0);

        List<Transaction> historyAcc = account.getTransactionHistory();
        List<Transaction> historyAcc2 = account2.getTransactionHistory();

        Transaction transferOutTransaction = historyAcc.get(1);
        Transaction transferInTransaction = historyAcc2.getFirst();

        // Assert
        assertTrue(result);
        assertEquals(2, historyAcc.size()); // 1 - deposit, 2 - transfer_out
        assertEquals(1, historyAcc2.size()); // 0 - transactions, none deposit/transfer_in
        assertEquals(TransactionType.TRANSFER_OUT, transferOutTransaction.getType());
        assertEquals(TransactionType.TRANSFER_IN, transferInTransaction.getType());
    }

    @Test
    void testTransferToTheSameAcc(){
        // Arange
        account.deposit(200.0);

        // Act
        boolean result = account.transferTo(account, 100.0);

        List<Transaction> historyAcc = account.getTransactionHistory();

        // Assert
        assertFalse(result);
        assertEquals(1, historyAcc.size()); // 1 - deposit, none transfer_out
    }

}
