package com.bankApplication.BankingApplicationSystem;

import com.bankApplication.BankingApplicationSystem.entity.Account;
import com.bankApplication.BankingApplicationSystem.entity.Amount;
import com.bankApplication.BankingApplicationSystem.exception.AccountOverflowException;
import com.bankApplication.BankingApplicationSystem.exception.AmountParserException;
import com.bankApplication.BankingApplicationSystem.service.AccountOperations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = {AccountOperations.class, Amount.class, Account.class})
public class AccountOperationsTest {

    AccountOperations accountOperations;

    @BeforeEach
    public void createAccountOperations() {
        accountOperations = new AccountOperations(new Account(new Amount()));
    }

    @Test
    public void testPerformCredit() throws AmountParserException, AccountOverflowException {
        Amount amount = new Amount("20D");
        accountOperations.performCredit(amount);
        assertThat(accountOperations.checkBalance().getCents()).isEqualTo(BigInteger.valueOf(2000));

        amount = new Amount("30D 10C");
        accountOperations.performCredit(amount);
        assertThat(accountOperations.checkBalance().getCents()).isEqualTo(BigInteger.valueOf(5010));

        amount = new Amount("50C");
        accountOperations.performCredit(amount);
        assertThat(accountOperations.checkBalance().getCents()).isEqualTo(BigInteger.valueOf(5060));
    }

    @Test
    public void testPerformDebit() throws AmountParserException, AccountOverflowException {
        Amount amount = new Amount("20D");
        accountOperations.performDebit(amount);
        assertThat(accountOperations.checkBalance().getCents()).isEqualTo(BigInteger.valueOf(-2000));

        amount = new Amount("30D 10C");
        accountOperations.performDebit(amount);
        assertThat(accountOperations.checkBalance().getCents()).isEqualTo(BigInteger.valueOf(-5010));

        amount = new Amount("50C");
        accountOperations.performDebit(amount);
        assertThat(accountOperations.checkBalance().getCents()).isEqualTo(BigInteger.valueOf(-5060));
    }
}
