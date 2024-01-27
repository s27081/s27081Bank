package com.example.s27081Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TransferServiceTest {

    private TransferService transferService;
    private TransferStorage transferStorage;
    private ClientStorage clientStorage;

    @BeforeEach
    void setup(){
        this.transferStorage = new TransferStorage();
        this.clientStorage = new ClientStorage();
        this.transferService = new TransferService(transferStorage,clientStorage);
        TransferStorage.transferList.clear();
        ClientStorage.clientList.clear();
    }

    @Test
    void registerNewClientTest(){
        transferService.registerNewClient(1,2500.0);

        assertThat(clientStorage.getClientList()).isNotEmpty();
    }

    @Test
    void isBalanceSufficientTest(){
        transferService.registerNewClient(1,2500.0);

        assertThat(transferService.isBalanceSufficient(1,2000)).isEqualTo(true);
    }

    @Test
    void notIsBalanceSufficientTest(){
        transferService.registerNewClient(1,2500.0);

        assertThat(transferService.isBalanceSufficient(1,3000)).isEqualTo(false);
    }
    //to fix
    @Test
    void subClientBalanceTest(){
        transferService.registerNewClient(1,2500.0);
        transferService.subClientBalance(1,500);

        assertThat(transferService.getClient(1).getBalance()).isEqualTo(2000.0);
    }

    @Test
    void addClientBalanceTest(){
        transferService.registerNewClient(1,2500.0);
        transferService.addBalance(1,2500.0);

        assertThat(transferService.getClient(1).getBalance()).isEqualTo(5000.0);
    }

}
