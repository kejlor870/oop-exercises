package org.example.model;

public class PremiumAccount extends BankAccount{
    private static final double OVERDRAFT_LIMIT = -1000.0;

    public PremiumAccount(String owner){
        super(owner);
    }

    @Override
    protected boolean isBalanceAllowed(double proposedBalance) {
        return proposedBalance >= OVERDRAFT_LIMIT;
    }
}
