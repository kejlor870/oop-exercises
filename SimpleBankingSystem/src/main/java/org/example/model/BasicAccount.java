package org.example.model;

public class BasicAccount extends BankAccount{

    public BasicAccount(String owner) {
        super(owner);
    }

    // Setting balance must be greater or equal 0
    @Override
    protected boolean isBalanceAllowed(double proposedBalance) {
        return proposedBalance >= 0;
    }

}
