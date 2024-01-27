package com.example.s27081Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ClientStorage {

    static List<Client> clientList = new ArrayList<>();

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        ClientStorage.clientList = clientList;
    }

    public void addClient(Client client){
        clientList.add(client);
    }
}
