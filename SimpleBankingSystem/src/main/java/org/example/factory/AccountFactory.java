package org.example.factory;

import org.example.model.BankAccount;
import org.example.model.BasicAccount;
import org.example.model.PremiumAccount;
import org.example.model.SavingsAccount;

public class AccountFactory {

    public static BankAccount createAccount(AccountType type, String owner){
        if(type == null){
            throw new IllegalArgumentException("Account type cannot be null");
        }

        return switch (type){
            case BASIC -> new BasicAccount(owner);
            case PREMIUM -> new PremiumAccount(owner);
            default -> throw new IllegalArgumentException("Creating account error: Invalid account type or provided variables for it.");
        };
    }
    
    public static BankAccount createAccount(AccountType type, String owner, double interest){
        if(type == null){
            throw new IllegalArgumentException("Account type cannot be null");
        }

        if(type == AccountType.SAVINGS){
            return new SavingsAccount(owner, interest);
        }else{
            throw new IllegalArgumentException("Creating account error: Invalid account type or provided variables for it.");
        }
    }
}
