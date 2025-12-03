package org.ies.tierno.objects.bank.model;
import java.util.Objects;
import lombok.Data;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor

public class Account {
    private String iban;
    private double balance;
    private Customer customer;

    public void showInfo() {
        System.out.println("IBAN: " + iban + ". Saldo: " + balance);
        System.out.print("Titular: ");
        customer.showInfo();
    }

    public void deposit(double amount){
        balance= balance+amount;
    }

    public boolean withdraw (double amount){
        if (balance>=amount){
            balance=balance-amount;
            return true;
        } else {
            System.out.println("No hay suficiente saldo");
            return false;
        }
    }
}
