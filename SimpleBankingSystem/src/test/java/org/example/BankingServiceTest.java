package org.example;

import org.example.model.BankAccount;
import org.example.service.BankingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankingServiceTest {
    private BankingService bankingService;

    @BeforeEach
    void setBankingService(){
        bankingService = new BankingService();
    }

    @Test
    void testBankingServiceCreatesNewAcc(){
        // Arange

        // Act
        BankAccount account = bankingService.createAccount("Kasia");

        // Assert
        assertInstanceOf(BankAccount.class, account);
    }

    @Test
    void testBankingServiceCreatesBlankNewAcc(){
        // Arange
        String blankName = "  ";

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {
            bankingService.createAccount(blankName);
        });
    }

    @Test
    void testBankingServiceTransfer(){
        // Arange
        BankAccount account1 = bankingService.createAccount("Kasia");
        BankAccount account2 = bankingService.createAccount("Jan");

        account1.deposit(200.0);

        // Act
        boolean result = bankingService.transfer(account1, account2, 100.0);

        // Assert
        assertTrue(result);
        assertEquals(100.0, account2.getBalance(), 0.001);
        assertEquals(100.0, account1.getBalance(), 0.001);
    }

    @Test
    void testBankingServiceTransferZero(){
        // Arange
        BankAccount account1 = bankingService.createAccount("Kasia");
        BankAccount account2 = bankingService.createAccount("Jan");

        account1.deposit(200.0);

        // Act
        boolean result = bankingService.transfer(account1, account2, 0.0);

        // Assert
        assertFalse(result);
        assertEquals(0.0, account2.getBalance(), 0.001);
        assertEquals(200.0, account1.getBalance(), 0.001);
    }

    @Test
    void testBankingServiceTransferToNullAcc(){
        // Arange
        BankAccount account1 = bankingService.createAccount("Kasia");
        account1.deposit(200.0);

        // Act
        boolean result = bankingService.transfer(account1, null, 0.0);

        // Assert
        assertFalse(result);
        assertEquals(200.0, account1.getBalance(), 0.001);
    }

    @Test
    void testBankingServiceAddsAccountToList(){
        // Arange
        bankingService.createAccount("Jan");

        // Act
        List<BankAccount> bankAccountList = bankingService.getBankAccountList();

        // Assert
        assertEquals(1, bankAccountList.size());
    }

}
