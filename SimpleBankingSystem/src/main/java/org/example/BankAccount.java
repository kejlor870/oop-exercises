package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String owner;
    private double balance = 0;
    private final List<Transaction> transactionHistory = new ArrayList<>();

    public BankAccount(String owner){
        if(owner == null || owner.isBlank()){
            throw new IllegalArgumentException("Owner name cannot be null or blank");
        }

        this.owner = owner;
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
        if(amount > 0 &&  Double.isFinite(amount)){
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
        return List.copyOf(transactionHistory);
    }
}
