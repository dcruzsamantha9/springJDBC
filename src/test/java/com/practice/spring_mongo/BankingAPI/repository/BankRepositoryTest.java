package com.practice.spring_mongo.BankingAPI.repository;

import com.practice.spring_mongo.BankingAPI.entity.Bank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class BankRepositoryTest {
    @Autowired
    private BankRepository bankRepository;

    public void save(){
        Bank bank= new Bank();
        bank.setBankCode(23);
        bank.setBankName("SBI");
        bank.setBankAddress("Whitefield");
        bankRepository.save(bank);
    }

    @Test
    public void findAll_whenDataExists_thenReturnBankDetails(){
        save();
        List<Bank> banks= bankRepository.findAll();
        assertEquals(1, banks.size());
    }
}
