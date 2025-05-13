package com.practice.spring_mongo.BankingAPI.service;

import com.practice.spring_mongo.BankingAPI.entity.Bank;
import com.practice.spring_mongo.BankingAPI.exception.BankDetailsNotFound;
import com.practice.spring_mongo.BankingAPI.model.BankRequest;
import com.practice.spring_mongo.BankingAPI.model.BankTO;
import jakarta.validation.Valid;

import java.util.List;

public interface BankService {
    List<BankTO> findAll() throws BankDetailsNotFound;

    BankTO findById(String id) throws BankDetailsNotFound;

    BankTO findByBankCode(int bankCode) throws BankDetailsNotFound;

    BankTO save(@Valid BankRequest bankRequest) throws BankDetailsNotFound;

    String delete(String id) throws BankDetailsNotFound;
}
