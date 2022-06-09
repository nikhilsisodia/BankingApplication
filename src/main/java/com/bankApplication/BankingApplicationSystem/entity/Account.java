package com.bankApplication.BankingApplicationSystem.entity;

public class Account {

    private Amount amount;

    public Account(Amount amount) {
        this.amount = amount;
    }

    public Amount getAmount() {return this.amount;}

    public void setAmount(Amount amount) {this.amount = amount;}
}
