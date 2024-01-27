package com.example.s27081Bank;

import org.springframework.stereotype.Component;


public class Transfer {
     private int clientId;

     private double moneyTransfer;

     private TransferStatus status;

     private double clientBalanceStatus;

    public Transfer(int clientId, double moneyTransfer) {
        this.clientId = clientId;
        this.moneyTransfer = moneyTransfer;
        this.status = TransferStatus.PROCESSING;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getMoneyTransfer() {
        return moneyTransfer;
    }

    public void setMoneyTransfer(double moneyTransfer) {
        this.moneyTransfer = moneyTransfer;
    }

    public TransferStatus getStatus() {
        return status;
    }

    public void setStatus(TransferStatus status) {
        this.status = status;
    }

    public double getClientBalanceStatus() {
        return clientBalanceStatus;
    }

    public void setClientBalanceStatus(double clientBalanceStatus) {
        this.clientBalanceStatus = clientBalanceStatus;
    }
}
