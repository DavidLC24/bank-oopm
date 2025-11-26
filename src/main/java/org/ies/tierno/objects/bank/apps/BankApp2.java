package org.ies.tierno.objects.bank.apps;

import org.ies.tierno.objects.bank.model.Account;
import org.ies.tierno.objects.bank.model.Bank;
import org.ies.tierno.objects.bank.readers.BankReader;

import java.util.Scanner;

public class BankApp2 {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp2(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
    Bank bank= bankReader.read();

    bank.showInfo();

    Account account1= bank.findAccount("ES0003");
    if (account1==null){
        System.out.println("No existe la cuenta ES0003");
    } else {
        account1.withdraw(50);
    }

    bank.showCustomerAccounts("000X");

    Account account2 = bank.findAccount("ES0001");
    if (account2!=null){
    account2.getCustomer().showInfo();
    }else {
        System.out.println("No existe la cuenta ES0001");
    }
    }
}
