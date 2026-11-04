package org.example;

import org.example.model.*;
import org.example.service.BankingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTypesTest {

    private BankingService bankingService;

    @BeforeEach
    void setBankingService(){
        bankingService = new BankingService();
    }

    @Test
    void testBasicAccountNotAllowsDebt(){
        // Arange
        BankAccount basicAccount = bankingService.createAccount("Jan");
        basicAccount.deposit(100.0);

        // Act
        boolean result = basicAccount.withdraw(200.0);

        // Assert
        assertFalse(result);
        assertEquals(100.0, basicAccount.getBalance());
        assertEquals(1, basicAccount.getTransactionHistory().size());
    }

    @Test
    void testSavingsAccountInterest(){
        // Arange
        BankAccount savingsAccount = bankingService.createSavingsAccount("Jan", 0.05);
        savingsAccount.deposit(1000.0);

        // Act
        // Casting on SavingsAccount
        ((SavingsAccount) savingsAccount).applyInterest();

        // Assert
        assertEquals(1050.0, savingsAccount.getBalance());
    }

    @Test
    void testSavingsAccountSavesInterestInTransactionHistory(){
        // Arange
        BankAccount savingsAccount = bankingService.createSavingsAccount("Jan", 0.05);
        savingsAccount.deposit(1000.0);

        // Act
        // Casting on SavingsAccount
        ((SavingsAccount) savingsAccount).applyInterest();
        List<Transaction> history = savingsAccount.getTransactionHistory();
        Transaction isInterest = history.get(1);

        // Assert
        assertEquals(2, savingsAccount.getTransactionHistory().size());
        assertEquals(TransactionType.INTEREST, isInterest.getType());
    }

    @Test
    void testPremiumAccountAllowsDebt(){
        // Arange
        BankAccount premiumAccount = bankingService.createPremiumAccount("Jan");
        premiumAccount.deposit(500.0);

        // Act
        boolean result = premiumAccount.withdraw(1200.0);

        // Assert
        assertTrue(result);
        assertEquals(-700.0, premiumAccount.getBalance());
    }

    @Test
    void testPremiumAccountRespectWithdrawLimit(){
        // Arange
        BankAccount premiumAccount = bankingService.createPremiumAccount("Jan");
        premiumAccount.deposit(100.0);

        // Act
        boolean result = premiumAccount.withdraw(1101.0);

        // Assert
        assertFalse(result);
        assertEquals(100.0, premiumAccount.getBalance());
    }

    @Test
    void testBankAccountHoldAllAccounts(){
        // Arange
        BankAccount basicAccount = bankingService.createAccount("Jan");
        BankAccount savingsAccount = bankingService.createSavingsAccount("Jan", 0.05);
        BankAccount premiumAccount = bankingService.createPremiumAccount("Jan");

        // Act
        List<BankAccount> accountList = bankingService.getBankAccountList();

        // Assert
        assertEquals(3, accountList.size());
    }

    @Test
    void testPremiumAccountRespectTransferLimit(){
        // Arange
        BankAccount premiumAccount = bankingService.createPremiumAccount("Jan");
        premiumAccount.deposit(100.0);

        // Act
        boolean result = premiumAccount.withdraw(700.0);

        // Assert
        assertTrue(result);
        assertEquals(-600.0, premiumAccount.getBalance());
    }
}
