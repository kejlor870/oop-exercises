package org.example;

import org.example.model.BankAccount;
import org.example.model.BasicAccount;

public class Main {
    public static void main(String[] args) {

        BankAccount account = new BasicAccount("Jan");

        account.deposit(203.3);
        account.withdraw(50.0);

        System.out.println("Account balance: " + String.format("%.2f", account.getBalance()));

        account.withdraw(2000.0);
        account.deposit(-20.0);

        System.out.println("Account balance: " + String.format("%.2f", account.getBalance()));

    }
}