package org.example.service;

import org.example.model.BankAccount;
import org.example.model.BasicAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankingService {
    private final List<BankAccount> bankAccountList = new ArrayList<>();

    public BankAccount createAccount(String owner){
        BankAccount newAccount = new BasicAccount(owner);

        // Add newAccount to the list of bank accounts
        bankAccountList.add(newAccount);

        return newAccount;
    }

    public boolean transfer(BankAccount account, BankAccount targetAccount, double amount){
        if(account == null || targetAccount == null) return false;

        // Checking if provided accounts are in BankingService bankAccountList
        boolean sourceAccountFound = false;
        boolean targetAccountFound = false;

        for(BankAccount savedBankAccount : this.bankAccountList){
            if(account == savedBankAccount){
                sourceAccountFound = true;
            }

            if(targetAccount == savedBankAccount){
                targetAccountFound = true;
            }

            if(sourceAccountFound && targetAccountFound){
                break;
            }
        }

        // Return false if any account are not in bankAccountList
        if(!sourceAccountFound || !targetAccountFound) return false;

        // Do transfer if provided accounts are in list and return true/false if success
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
