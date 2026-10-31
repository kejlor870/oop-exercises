package org.example.service;

import org.example.model.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public BankAccount findAccountById(String accountId){
        for(BankAccount account : bankAccountList){
            if(Objects.equals(account.getUniqueID(), accountId)){
                return account;
            }
        }

        throw new RuntimeException("Not found account with ID: " +  accountId);
    }

}
