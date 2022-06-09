package com.bankApplication.BankingApplicationSystem;


import com.bankApplication.BankingApplicationSystem.controller.AccountController;
import com.bankApplication.BankingApplicationSystem.service.AccountOperations;
import org.springframework.beans.factory.annotation.Autowired;

public class BankingApplicationSystemApplication {

	public static AccountController accountController = new AccountController();
	public static void main(String[] args) {
		accountController.run();
	}

}
