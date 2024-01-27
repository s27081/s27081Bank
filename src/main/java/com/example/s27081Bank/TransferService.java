package com.example.s27081Bank;

import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private TransferStorage transferStorage;

    private ClientStorage clientStorage;

    public TransferService(TransferStorage transferStorage, ClientStorage clientStorage) {
        this.transferStorage = new TransferStorage();
        this.clientStorage = new ClientStorage();
    }

    void registerNewClient(int clientId, double balance) {
        clientStorage.addClient(new Client(clientId, balance));
    }

    boolean isBalanceSufficient(int clientId, double transfer) {
        for (Client client : ClientStorage.clientList) {
            if (clientId == client.getClientId()) {
                if (client.getBalance() - transfer > 0.0) {
                    return true;
                }
            }
        }
        return false;
    }

    void subClientBalance(int clientId, double money) {
        for (Client client : ClientStorage.clientList) {
            if (clientId == client.getClientId()) {
                double currentBalance = client.getBalance();
                client.setBalance(currentBalance - money);
            }
        }
    }

    void addClientBalance(int clientId, double money) {
        for (Client client : ClientStorage.clientList) {
            if (clientId == client.getClientId()) {
                double currentBalance = client.getBalance();
                client.setBalance(currentBalance + money);
            }
        }
    }


    Transfer orderTransfer(int clientId, double moneyTransfer) {
        if (isBalanceSufficient(clientId, moneyTransfer) && doesClientExist(clientId)) {
            subClientBalance(clientId, moneyTransfer);
            Transfer transfer = new Transfer(clientId, moneyTransfer);
            transfer.setClientBalanceStatus(getClientBalance(clientId));
            transferStorage.addTransfer(transfer);
            return transfer;
        } else {
            Transfer transfer = new Transfer(clientId, moneyTransfer);
            transfer.setStatus(TransferStatus.DECLINED);
            transferStorage.addTransfer(transfer);
            return transfer;
     }

}

    Transfer addBalance(int clientId, double moneyTransfer) {
        if (doesClientExist(clientId)) {
            addClientBalance(clientId, moneyTransfer);
            Transfer transfer = new Transfer(clientId, moneyTransfer);
            transfer.setClientBalanceStatus(getClientBalance(clientId));
            transferStorage.addTransfer(transfer);
            return transfer;
        }else{
            Transfer transfer = new Transfer(clientId, moneyTransfer);
            transfer.setStatus(TransferStatus.DECLINED);
            transferStorage.addTransfer(transfer);
            return transfer;
        }

    }

    Client getClient(int clientId) {
        for (Client client : ClientStorage.clientList) {
            if (client.getClientId() == clientId) {
                return client;
            } else {
                System.out.println("Klient nie istnieje");
            }
        }
        return null;
    }

    double getClientBalance(int clientId){
        for (Client client : ClientStorage.clientList) {
            if (client.getClientId() == clientId) {
                return client.getBalance();
            } else {
                System.out.println("Klient nie istnieje");
            }
        }
        return 0;
    }

    boolean doesClientExist(int clientId) {
        for (Client client : ClientStorage.clientList) {
            if (client.getClientId() == clientId) {
                return true;
            }
        }
        return false;
    }
}