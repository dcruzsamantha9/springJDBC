package com.practice.spring_mongo.BankingAPI;

import org.springframework.boot.SpringApplication;

public class TestBankingApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(BankingApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
