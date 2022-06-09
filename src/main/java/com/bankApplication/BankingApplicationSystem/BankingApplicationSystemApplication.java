package com.bankApplication.BankingApplicationSystem;


import com.bankApplication.BankingApplicationSystem.controller.AccountController;
import com.bankApplication.BankingApplicationSystem.entity.Account;
import com.bankApplication.BankingApplicationSystem.entity.Amount;
import com.bankApplication.BankingApplicationSystem.exception.AmountParserException;
import com.bankApplication.BankingApplicationSystem.service.AccountOperations;


public class BankingApplicationSystemApplication {

	private static AccountController accountController = new AccountController(new AccountOperations(new Account(new Amount())));

	public static void main(String[] args) throws AmountParserException {
		accountController.run();
	}

}
