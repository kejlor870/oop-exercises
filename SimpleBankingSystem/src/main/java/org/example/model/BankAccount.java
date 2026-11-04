package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class BankAccount {
    private final String uniqueID; // ex. f81d4fae-7dec-11d0-a765-00a0c91e6bf6
    private final String owner;
    private double balance = 0;
    private final List<Transaction> transactionHistory = new ArrayList<>();

    public BankAccount(String owner){
        if(owner == null || owner.isBlank()){
            throw new IllegalArgumentException("Owner name cannot be null or blank");
        }

        this.uniqueID = UUID.randomUUID().toString(); // ex. f81d4fae-7dec-11d0-a765-00a0c91e6bf6
        this.owner = owner;
    }

    // Method to get account uniqueID
    public String getUniqueID() {
        return uniqueID;
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
        return credit(amount, TransactionType.DEPOSIT);
    }

    // Method to withdraw
    public boolean withdraw(double amount){
        if(amount <= getBalance() && amount > 0){
            // Deduction form the balance
            double newBalance = this.balance - amount;

            // Validate for incorrect balance
            if(!Double.isFinite(newBalance) || !isBalanceAllowed(newBalance)) return false;

            this.balance = newBalance;

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

    // Method to transfer money from account to another account
    public boolean transferTo(BankAccount target, double amount){
        // Validation
        if(target == null) return false;
        if(amount <= 0.0 || !Double.isFinite(amount)) return false;
        if(target == this) return false;

        double newSourcebalance = this.balance - amount;
        double newTargetBalance = target.balance + amount;

        if(!Double.isFinite(newSourcebalance) || !Double.isFinite(newTargetBalance)) return false;
        if(!this.isBalanceAllowed(newSourcebalance) || !target.isBalanceAllowed(newTargetBalance)) return false;

        // Transfer out
        this.balance -= amount;
        this.transactionHistory.add(new Transaction(TransactionType.TRANSFER_OUT, amount));

        // Transfer in
        target.balance += amount;
        target.transactionHistory.add(new Transaction(TransactionType.TRANSFER_IN, amount));

        return true;
    }

    // Allow to set negative balance for special type accounts
    protected abstract boolean isBalanceAllowed(double proposedBalance);

    // Method to add credit to balance and history, deposit / interest
    protected final boolean credit(double amount, TransactionType type){
        if(amount <= 0 || !Double.isFinite(amount) || type == null) return false;

        double newBalance = this.balance + amount;

        if(!Double.isFinite(newBalance) || !isBalanceAllowed(newBalance)) return false;

        this.balance = newBalance;
        transactionHistory.add(new Transaction(type, amount));

        return true;
    }
}
