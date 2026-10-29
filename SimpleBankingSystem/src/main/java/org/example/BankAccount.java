package org.example;

public class BankAccount {
    private final String owner;
    private double balance = 0;

    public BankAccount(String owner){
        this.owner = owner;
    }

    // Method to get balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit
    public boolean deposit(double amount){
        if(amount > 0){
            this.balance += amount;

            return true;
        }

        return false;
    }

    // Method to withdraw
    public boolean withdraw(double amount){
        if(amount < getBalance() && amount > 0){
            this.balance -= amount;
            return true;
        }

        return false;
    }

}
