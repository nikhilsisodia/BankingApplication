package com.bankApplication.BankingApplicationSystem.service;

import com.bankApplication.BankingApplicationSystem.entity.Account;
import com.bankApplication.BankingApplicationSystem.entity.Amount;
import com.bankApplication.BankingApplicationSystem.exception.AccountOverflowException;

import java.math.BigInteger;

public class AccountOperations {

    private Account account;
    private static BigInteger MAXAMOUNT = new BigInteger("100000000000");

    public AccountOperations(Account account) {
        this.account = account;
    }

    public void performCredit(Amount amount) throws AccountOverflowException {
        Amount newAmount = this.account.getAmount().add(amount);
        if(newAmount.getCents().compareTo(MAXAMOUNT) > 0)
            throw new AccountOverflowException();
        this.account.setAmount(newAmount);
    }

    public void performDebit(Amount amount) throws AccountOverflowException {
        Amount newAmount = this.account.getAmount().subtract(amount);
        if(newAmount.getCents().compareTo(MAXAMOUNT) > 0)
            throw new AccountOverflowException();
        this.account.setAmount(newAmount);
    }

    public Amount checkBalance() {
        return this.account.getAmount();
    }
}
