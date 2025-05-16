package com.practice.spring_mongo.BankingAPI.service;


import com.practice.spring_mongo.BankingAPI.entity.Bank;
import com.practice.spring_mongo.BankingAPI.exception.BankDetailsNotFound;
import com.practice.spring_mongo.BankingAPI.model.BankRequest;
import com.practice.spring_mongo.BankingAPI.model.BankTO;
import com.practice.spring_mongo.BankingAPI.repository.BankRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankServiceImplTest {

    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankServiceImpl bankService;

    @Test
    public void findAll_whenBankDetailsExist_thenReturnBankDetails() throws BankDetailsNotFound {
        Bank bank= new Bank();
        bank.setBankCode(88);
        bank.setBankName("Corp");
        bank.setBankAddress("Kora");
        List<Bank> banks= new ArrayList<>();
        banks.add(bank);
        when(bankRepository.findAll()).thenReturn(banks);

        List<BankTO> bankTOS = bankService.findAll();
        assertEquals(1, bankTOS.size());
    }

    @Test
    public void findAll_whenBankNotExist_thenThrowBankDetailsNotFound(){
        List<Bank> banks= null;

        when(bankRepository.findAll()).thenReturn(banks);

        BankDetailsNotFound thrown = assertThrows(BankDetailsNotFound.class, ()-> bankService.findAll());
        assertEquals("Bank Details not found", thrown.getMessage());
    }

    @Test
    public void findById_whenBankDetailsExist_thenReturnBankDetails() throws BankDetailsNotFound {
        Bank bank = new Bank();
        bank.setBankCode(23);
        bank.setBankName("SBI");
        bank.setBankAddress("Hebbal");

        when(bankRepository.findById(anyString())).thenReturn(Optional.of(bank));
        BankTO bankTO= bankService.findById(anyString());
        assertEquals(23, bankTO.getBankCode());
        assertEquals("SBI", bankTO.getBankName());
        assertEquals("Hebbal", bankTO.getBankAddress());
    }

    @Test
    public void findById_whenBankDetailsNotFound_thenThrowBankDetailsNotFoundEx() throws BankDetailsNotFound {
        Bank bank=null;
        when(bankRepository.findById(anyString())).thenReturn(Optional.ofNullable(bank));
        BankDetailsNotFound thrown = assertThrows(BankDetailsNotFound.class, () -> bankService.findById(anyString()));
        assertEquals("Bank Details not found", thrown.getMessage());
    }

    @Test
    public void findByBankCode_whenBankDetailsExist_thenReturnBankDetails() throws BankDetailsNotFound {
        Bank bank= new Bank();
        bank.setBankCode(12);
        bank.setBankName("SBI");
        bank.setBankAddress("Hebbal");
        when(bankRepository.findByBankCode(23)).thenReturn(Optional.of(bank));
        BankTO bankTO= bankService.findByBankCode(23);
        assertEquals(12, bankTO.getBankCode());
        assertEquals("SBI", bankTO.getBankName());
        assertEquals("Hebbal", bankTO.getBankAddress());
    }

    @Test
    public void findByBankCode_whenBankNotExist_thenThrowBankDetailsNotFoundEx(){
        Bank bank= null;
        when(bankRepository.findByBankCode(12)).thenReturn(Optional.ofNullable(bank));
        BankDetailsNotFound thrown = assertThrows(BankDetailsNotFound.class, () -> bankService.findByBankCode(12));
        assertEquals("Bank Details not found", thrown.getMessage());
    }

    @Test
    public void save_whenBankDetailsExist_thenReturnBankDetails() throws BankDetailsNotFound {
        Bank bank= new Bank();
        bank.setBankCode(12);
        bank.setBankName("SBI");
        bank.setBankAddress("Hebbal");
        when(bankRepository.save(any())).thenReturn(bank);

        BankRequest bankRequest = new BankRequest();
        bankRequest.setBankCode(12);
        bankRequest.setBankName("SBI");
        bankRequest.setBankAddress("Hebbal");

        BankTO bankTO = bankService.save(bankRequest);
        assertEquals(12, bankTO.getBankCode());
        assertEquals("SBI", bankTO.getBankName());
        assertEquals("Hebbal", bankTO.getBankAddress());
    }

    @Test
    public void save_whenBankDetailsNotFound_thenThrowBankDetailsNotFoundEx(){
        Bank bank=null;
        BankRequest bankRequest= new BankRequest();
        when(bankRepository.save(any())).thenReturn(bank);
        BankDetailsNotFound thrown = assertThrows(BankDetailsNotFound.class, ()-> bankService.save(bankRequest));
        assertEquals("Bank Details not found", thrown.getMessage());
    }

    @Test
    public void delete_whenBankDetailsExist_thenReturnMessage() throws BankDetailsNotFound {
        String msg = "Record has been deleted";
        Bank bank = new Bank();
        when(bankRepository.findById(anyString())).thenReturn(Optional.of(bank));
        String x= bankService.delete(anyString());
        assertEquals(msg, x);
    }
    @Test
    public void delete_whenBankDetailsNotFound_thenThrowException(){
        String id = null;
        Bank bank = new Bank();
        when(bankRepository.findById(id)).thenReturn(Optional.ofNullable(bank));
        BankDetailsNotFound thrown = assertThrows(BankDetailsNotFound.class, ()-> bankService.delete(id));
        assertEquals("Bank Details not found", thrown.getMessage());
    }


}
