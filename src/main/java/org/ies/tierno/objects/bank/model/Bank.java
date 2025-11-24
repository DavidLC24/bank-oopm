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

    public Account finAccount(String iban){
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
    public void money (String iban, int dinero){
        var found= false;
        for (Account account: accounts){
            if (account.getIban().equals(iban+dinero)){
                account.showInfo();
                found= true;
            }
        }
        if(!found){
            System.out.println("No se encuentra la cuenta");
        }
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
