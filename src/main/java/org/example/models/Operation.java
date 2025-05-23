package org.example.models;

public class Operation {
    private int id;
    private double amount;
    private OperationStatus status;
    private BankAccount accountId;

    public enum OperationStatus {
        WITHDRAWAL, DEPOSIT
    }

    public Operation() {

    }

    public Operation(int id, double amount, OperationStatus status, BankAccount accountId) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.accountId = accountId;
    }

    public BankAccount getAccountId() {
        return this.accountId;
    }

    public void setAccountId(BankAccount accountId) {
        this.accountId = accountId;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", amount=" + amount +
                ", status=" + status +
                ", accountId=" + accountId +
                '}';
    }
}
