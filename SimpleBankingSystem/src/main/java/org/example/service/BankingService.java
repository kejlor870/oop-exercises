package org.example.service;

import org.example.model.BankAccount;

public class BankingService {

    public BankAccount createAccount(String owner){
        if(owner.isBlank() || owner.isEmpty()){
            throw new IllegalArgumentException("Owner name can not be empty or blank.");
        }

        return new BankAccount(owner);
    }

    public boolean transfer(BankAccount account, BankAccount targetAccount, double amount){
        if(account == null || targetAccount == null) return false;
        if(amount <= 0.0 || !Double.isFinite(amount)) return false;
        if(account.getBalance() < amount) return false;
        if(targetAccount == account) return false;

        return account.transferTo(targetAccount, amount);
    }

}
