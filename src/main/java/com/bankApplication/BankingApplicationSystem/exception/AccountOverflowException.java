package com.bankApplication.BankingApplicationSystem.exception;

public class AccountOverflowException extends Exception {
    public AccountOverflowException () {
        super("Maximum amount that can be stored in the account is 10^9 dollars");
    }
}
