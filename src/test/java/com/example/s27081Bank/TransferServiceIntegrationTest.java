package com.example.s27081Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TransferServiceIntegrationTest {

    private TransferService transferService;
    private TransferStorage transferStorage;
    private ClientStorage clientStorage;

    @BeforeEach
    void setup() {
        this.transferStorage = new TransferStorage();
        this.clientStorage = new ClientStorage();
        this.transferService = new TransferService(transferStorage, clientStorage);
        TransferStorage.transferList.clear();
        ClientStorage.clientList.clear();
    }
    @Test
    void addClientMakeOrderAndAddBalanceTest(){
        transferService.registerNewClient(1,10500.0);

        transferService.orderTransfer(1,500.0);

        transferService.addBalance(1,5000.0);
        assertThat(transferService.getClientBalance(1)).isEqualTo(15000.0);
    }
    @Test
    void addClientMakeDeclineTransferAddBalanceRepeatTransfer(){
        transferService.registerNewClient(1,1500.0);

        transferService.orderTransfer(1,50000.0);

        transferService.addBalance(1,49000.0);

        transferService.orderTransfer(1,50000.0);
        assertThat(transferService.getClientBalance(1)).isEqualTo(500.0);
    }
}