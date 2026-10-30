package org.example;

import java.time.LocalDateTime;

public class Transaction {
    private final TransactionType type;
    private final double amount;
    private final LocalDateTime time;

    public Transaction(TransactionType type, double amount){
        if(type == null || !Double.isFinite(amount)){
            throw new IllegalArgumentException("Wrong type or amount");
        }

        this.type = type;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
