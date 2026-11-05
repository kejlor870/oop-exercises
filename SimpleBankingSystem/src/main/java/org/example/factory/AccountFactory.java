package org.example.factory;

import org.example.model.BankAccount;
import org.example.model.BasicAccount;
import org.example.model.PremiumAccount;
import org.example.model.SavingsAccount;

public class AccountFactory {

    public static BankAccount createAccount(AccountType type, String owner, double interest){
        return switch (type){
            case BASIC -> new BasicAccount(owner);
            case PREMIUM -> new PremiumAccount(owner);
            case SAVINGS -> new SavingsAccount(owner, interest);
            default -> throw new IllegalArgumentException("Creating account error: Invalid account type.");
        };
    }
}
