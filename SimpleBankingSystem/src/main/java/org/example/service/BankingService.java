package org.example.service;

import org.example.model.BankAccount;

public class BankingService {

    public BankAccount createAccount(String owner){
        return new BankAccount(owner);
    }

    public boolean transfer(BankAccount account, BankAccount targetAccount, double amount){
        if(account == null || targetAccount == null) return false;

        return account.transferTo(targetAccount, amount);
    }

}
