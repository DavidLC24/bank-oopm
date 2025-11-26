package org.ies.tierno.objects.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public void showInfo(){
        System.out.println("Banco"+name);
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Cuenta "+i);
            accounts[i].showInfo();
        }
    }
    public void accountsBank(){
        getAccounts();
    }

    public void infoAccount(String iban){
        var found= false;
        for (Account account : accounts){
            if (account.getIban().equals(iban)){
                account.showInfo();
                found= true;
            }
        }
        if (!found){
            System.out.println("Cuenta no encontrada");
        }
    }

    public void showCustomerAccounts(String nif) {
        for (var account : accounts) {
            Customer customer = account.getCustomer();
            if (customer.getNif().equals(nif)) {
                account.showInfo();
            }
        }
    }

    public Account findAccount(String iban){
        for (Account account : accounts){
            if (account.getIban().equals(iban)){
                return account;
    }}
    return null;}

    public void finAccount2(String nif){
        for (Account account : accounts){
            Customer customer= account.getCustomer();
            if (account.getCustomer().getNif().equals(nif)){
                account.showInfo();
                }
            }
        }
    public void deposit (String iban, double amount){
        Account account= findAccount(iban);
            if (account==null) {
                System.out.println("No se encuentra la cuenta");
            }
            else{
            account.deposit(amount);
        }
    }

    public Customer findAccountCustomer(String iban) {
        var account = findAccount(iban);
        if (account == null) {
            return null;
        } else {
            return account.getCustomer();
        }
    }

    public int countCustomerAccounts(String nif) {
        int count = 0;
        for (var account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                count++;
            }
        }
        return count;
    }

    public boolean transfer(String ibanOrigin, String ibanDestination, double amount) {
        var origin = findAccount(ibanOrigin);
        var destination = findAccount(ibanDestination);
        if (origin != null && destination != null) {
            if (origin.getBalance() >= amount) {
                origin.withdraw(amount);
                destination.deposit(amount);
                return true;
            }
        } else {
            System.out.println("No exista la cuenta de origen o destino");
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
