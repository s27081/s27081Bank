package com.example.s27081Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TransferStorage {

    static List<Transfer> transferList = new ArrayList<>();

    public List<Transfer> getTransferList() {
        return transferList;
    }

    public static void setTransferList(List<Transfer> transferList) {
        TransferStorage.transferList = transferList;
    }

    public void addTransfer(Transfer transfer){
        transferList.add(transfer);
    }
}
