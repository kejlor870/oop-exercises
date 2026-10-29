package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String owner;
    private double balance = 0;
    private List<Transaction> transactionHistory;

    public BankAccount(String owner){
        this.owner = owner;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to get owner name
    public String getOwner() {
        return owner;
    }

    // Method to get balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit
    public boolean deposit(double amount){
        if(amount > 0){
            // Add to the balance
            this.balance += amount;

            // Add new transaction to history
            this.transactionHistory.add(new Transaction(TransactionType.DEPOSIT, amount));

            return true;
        }

        return false;
    }

    // Method to withdraw
    public boolean withdraw(double amount){
        if(amount <= getBalance() && amount > 0){
            // Deduction form the balance
            this.balance -= amount;

            // Add new transaction to history
            this.transactionHistory.add(new Transaction(TransactionType.WITHDRAW, amount));

            return true;
        }

        return false;
    }

    // Method to return transactionsHistory
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
