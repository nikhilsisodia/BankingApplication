package com.bankApplication.BankingApplicationSystem.service.impl;

import com.bankApplication.BankingApplicationSystem.service.AccountOperations;

public class AccountOperationsImpl implements AccountOperations {

    @Override
    public void performCredit() {
        System.out.println("Inside credit\n");
    }

    @Override
    public void performDebit() {
        System.out.println("Inside debit\n");
    }

    @Override
    public void checkBalance() {
        System.out.println("Inside check Balance\n");
    }
}
