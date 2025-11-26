package org.ies.tierno.objects.bank.apps;

import org.ies.tierno.objects.bank.model.Account;
import org.ies.tierno.objects.bank.model.Bank;
import org.ies.tierno.objects.bank.readers.BankReader;

import java.util.Scanner;

public class BankApp3 {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp3(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }
    public void run(){
        var bank = bankReader.read();
        Account account1= bank.findAccount("ES0001");
        if (account1==null){
            System.out.println("Error");
        } else {
            account1.showInfo();
            bank.transfer("ES0001", "ES0002", account1.getBalance());
            bank.showInfo();
        }
    }
}

