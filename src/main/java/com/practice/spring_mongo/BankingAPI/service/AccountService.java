package com.practice.spring_mongo.BankingAPI.service;

import com.practice.spring_mongo.BankingAPI.exception.AccountNotFound;
import com.practice.spring_mongo.BankingAPI.model.AccountRequest;
import com.practice.spring_mongo.BankingAPI.model.AccountTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountService {
    List<AccountTO> getAllAccount() throws AccountNotFound;

    AccountTO findByAccId(String id) throws AccountNotFound;

    AccountTO findByAccNo(int accNo) throws AccountNotFound;

    AccountTO save(AccountRequest accountRequest) throws AccountNotFound;

    String delete(String id) throws AccountNotFound;


}
