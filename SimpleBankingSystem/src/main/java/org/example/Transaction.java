package org.example;

public class Transaction {
    private final TransactionType type;
    private final double amount;

    public Transaction(TransactionType type, double amount){
        this.type = type;
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
