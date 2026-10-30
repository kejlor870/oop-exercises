package org.example;

public class Transaction {
    private final TransactionType type;
    private final double amount;

    public Transaction(TransactionType type, double amount){
        if(type == null && Double.isFinite(amount)){
            throw new IllegalArgumentException("Wrong type or amount");
        }

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
