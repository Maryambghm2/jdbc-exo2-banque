package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int id;
    private Customer customer;
    private List<Operation> operations = new ArrayList<>();
    private int accountId;


public BankAccount() {

}

public BankAccount(int id, Customer customer, List<Operation> operations,int accountId){
    this.id = id;
    this.customer = customer;
    this.operations = operations;
    this.accountId = accountId;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", customer=" + customer +
                ", operations=" + operations +
                ", accountId=" + accountId +
                '}';
    }

}
