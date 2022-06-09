/**
 * @author nikhil sisodia
 */
package com.bankApplication.BankingApplicationSystem.controller;

import com.bankApplication.BankingApplicationSystem.service.AccountOperations;
import com.bankApplication.BankingApplicationSystem.service.impl.AccountOperationsImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 * This class is used to invoke all the crud operations.
 */
public class AccountController {

    AccountOperationsImpl accountOperations = new AccountOperationsImpl();

    /**
     * This run function operates when it is called from main.
     */
    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int choice;
        do{
            System.out.println("Select an option:\n" +
                    "1. Credit\n" +
                    "2. Debit\n" +
                    "3. Check Balance\n" +
                    "4. Exit");
            choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    accountOperations.performCredit();
                    break;
                case 2:
                    accountOperations.performDebit();
                    break;
                case 3:
                    accountOperations.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you!");
                    flag = false;
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        }while(flag);
    }
}
