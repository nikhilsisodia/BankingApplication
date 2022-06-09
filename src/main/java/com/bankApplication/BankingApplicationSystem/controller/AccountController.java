/**
 * @author nikhil sisodia
 */
package com.bankApplication.BankingApplicationSystem.controller;

import com.bankApplication.BankingApplicationSystem.entity.Account;
import com.bankApplication.BankingApplicationSystem.entity.Amount;
import com.bankApplication.BankingApplicationSystem.exception.AmountParserException;
import com.bankApplication.BankingApplicationSystem.service.AccountOperations;

import java.util.Scanner;

/**
 * This class is used to invoke all the crud operations.
 */
public class AccountController {

    private AccountOperations accountOperations;

    public AccountController(AccountOperations accountOperations) {
        this.accountOperations = accountOperations;
    }

    /**
     * This run function operates when it is called from main.
     */
    public void run() throws AmountParserException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:\n" +
                    "1. Credit\n" +
                    "2. Debit\n" +
                    "3. Check Balance\n" +
                    "4. Exit");
            Integer choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter Amount ");
                    try {
                        String input = scanner.nextLine();
                        Amount creditAmount = new Amount(input);
                        accountOperations.performCredit(creditAmount);
                    }
                    catch (Exception ex) {
                        System.out.println(ex.toString());
                    }
                    break;
                case 2:
                    System.out.println("Enter Amount ");
                    try {
                        String input = scanner.nextLine();
                        Amount debitAmount = new Amount(input);
                        accountOperations.performDebit(debitAmount);
                    }
                    catch (Exception ex) {
                        System.out.println(ex.toString());
                    }
                    break;
                case 3:
                    System.out.println("Current Balance is " + accountOperations.checkBalance().toString());
                    break;
                case 4:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        }
    }
}
