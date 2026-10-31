package org.example.service;

import org.example.model.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankingService {
    private final List<BankAccount> bankAccountList = new ArrayList<>();

    public BankAccount createAccount(String owner){
        BankAccount newAccount = new BankAccount(owner);

        // Add newAccount to the list of bank accounts
        bankAccountList.add(newAccount);

        return newAccount;
    }

    public boolean transfer(BankAccount account, BankAccount targetAccount, double amount){
        if(account == null || targetAccount == null) return false;

        return account.transferTo(targetAccount, amount);
    }

    public List<BankAccount> getBankAccountList() {
        return List.copyOf(bankAccountList);
    }
}
