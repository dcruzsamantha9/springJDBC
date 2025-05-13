package com.practice.spring_mongo.BankingAPI.service;

import com.practice.spring_mongo.BankingAPI.entity.Account;
import com.practice.spring_mongo.BankingAPI.exception.AccountNotFound;
import com.practice.spring_mongo.BankingAPI.model.AccountRequest;
import com.practice.spring_mongo.BankingAPI.model.AccountTO;
import com.practice.spring_mongo.BankingAPI.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<AccountTO> getAllAccount() throws AccountNotFound{
        log.info("Inside AccountServiceImpl.findAll");
        List<Account> accounts = accountRepository.findAll();

        if(CollectionUtils.isEmpty(accounts)){
            log.error("Account Details not found");
            throw new AccountNotFound("Account Details not found");
        }

        List<AccountTO> accountTOS = accounts.stream().map( acc -> {
                    AccountTO accountTO = new AccountTO();
                    accountTO.setAccNo(acc.getAccNo());
                    accountTO.setAccType(acc.getAccType());
                    accountTO.setAccBalance(acc.getAccBalance());
                    return accountTO;
        }).collect(Collectors.toList());
        log.info("Outside AccountServiceImpl.findAll");
        return accountTOS;
    }

    @Override
    public AccountTO findByAccId(String id) throws AccountNotFound {
        log.info("Inside AccoutnService.findByAccID");
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isEmpty()){
            log.error("Account Details not found");
            throw new AccountNotFound("Account Details not found");
        }
        Account account= accountOptional.get();
        AccountTO accountTO= new AccountTO();
        accountTO.setAccNo(account.getAccNo());
        accountTO.setAccType(account.getAccType());
        accountTO.setAccBalance(account.getAccBalance());
        log.info("Outside AccountServiceImpl.findById");
        return accountTO;
    }

    @Override
    public AccountTO findByAccNo(int accNo) throws AccountNotFound {
        log.info("Inside AccountService.findByAccNo");
        Optional<Account> accountOptional= accountRepository.findByAccNo(accNo);
        if(accountOptional.isEmpty()){
            log.error("Account Number not found");
            throw new AccountNotFound("Account Number not found");
        }
        Account account=accountOptional.get();
        AccountTO accountTO= new AccountTO();
        accountTO.setAccBalance(account.getAccNo());
        accountTO.setAccType(account.getAccType());
        accountTO.setAccBalance(account.getAccBalance());
        log.info("Outside AccountServiceImpl.findByAccNo");
        return accountTO;
    }

    @Override
    public AccountTO save(AccountRequest accountRequest) throws AccountNotFound {
        log.info("Inside AccountServiceImpl.save");
        Account account= new Account();
        account.setAccNo(accountRequest.getAccNo());
        account.setAccType(accountRequest.getAccType());
        account.setAccBalance(accountRequest.getAccBalance());

        Account account1= accountRepository.save(account);

        if(Objects.isNull(account1)){
            log.error("Account Details could not be uploaded");
            throw new AccountNotFound("Account Details could not be fetched");
        }

        AccountTO accountTO= new AccountTO();
        accountTO.setAccNo(account1.getAccNo());
        accountTO.setAccType(account1.getAccType());
        accountTO.setAccBalance(account1.getAccBalance());
        log.info("Outside AccountServiceImpl.save");
        return accountTO;
    }

    @Override
    public String delete(String id) throws AccountNotFound {
        Optional<Account> accountOptional= accountRepository.findById(id);
        if(accountOptional.isEmpty()){
            log.error("Record could not be deleted");
            throw new AccountNotFound("Account Id could not be found");
        }
        accountRepository.deleteById(id);
        return "Account Detail has been successfully removed";
    }


}
