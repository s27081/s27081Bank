package com.example.s27081Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S27081BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(S27081BankApplication.class, args);
	}

	private final TransferService transferService;
	private final TransferStorage transferStorage;
	private final ClientStorage clientStorage;

	public S27081BankApplication(TransferService transferService, TransferStorage transferStorage, ClientStorage clientStorage) {
		this.transferService = transferService;
		this.transferStorage = transferStorage;
		this.clientStorage = clientStorage;

		//init_process();
	}

	public void init_process(){
		transferService.registerNewClient(11,2000.0);

		transferService.orderTransfer(11,200.0);
		transferService.addBalance(11, 2500.0);
		transferService.getClient(1);
	}

}
