package com.example.s27081Bank;

import org.springframework.stereotype.Component;


public class Client {
    private int clientId;
    private double balance;

    public Client(int clientId, double balance) {
        this.clientId = clientId;
        this.balance = balance;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
