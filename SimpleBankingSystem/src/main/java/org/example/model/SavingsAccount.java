package org.example.model;

public class SavingsAccount extends BankAccount{
    private final double interestRate;

    public SavingsAccount(String owner, double interestRate){
        super(owner);

        if(interestRate < 0.01 || !Double.isFinite(interestRate)){
            throw new IllegalArgumentException("Invalid interest rate");
        }

        this.interestRate = interestRate;
    }

    @Override
    protected boolean isBalanceAllowed(double proposedBalance) {
        return proposedBalance >= 0;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public boolean applyInterest(){
        double interest = getBalance() * this.interestRate;

        return credit(interest, TransactionType.INTEREST);
    }
}
