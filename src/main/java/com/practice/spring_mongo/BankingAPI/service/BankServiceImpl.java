package com.practice.spring_mongo.BankingAPI.service;

import com.practice.spring_mongo.BankingAPI.entity.Bank;
import com.practice.spring_mongo.BankingAPI.exception.BankDetailsNotFound;
import com.practice.spring_mongo.BankingAPI.model.BankRequest;
import com.practice.spring_mongo.BankingAPI.model.BankTO;
import com.practice.spring_mongo.BankingAPI.repository.BankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankRepository bankRepository;


    @Override
    public List<BankTO> findAll() throws BankDetailsNotFound {
        log.info("Inside Service Impl.findAll");
        List<Bank> banks = bankRepository.findAll();

        if (CollectionUtils.isEmpty(banks)) {
            log.error("Banks have no records");
            throw new BankDetailsNotFound("Bank details not found");
        }

        List<BankTO> bankTOS = banks.stream().map(bank ->
        {
            BankTO bankTO = new BankTO();
            bankTO.setBankCode(bank.getBankCode());
            bankTO.setBankName(bank.getBankName());
            bankTO.setBankAddress(bank.getBankAddress());
            return bankTO;
        }).collect(Collectors.toList());
        log.info("Outside Bank Service Impl.findAll");
        return bankTOS;
    }

    @Override
    public BankTO findById(String id) throws BankDetailsNotFound {
        log.info("Inside Service Impl.findById");
        Optional<Bank> bankOptional = bankRepository.findById(id);
        if (bankOptional.isEmpty()) {
            log.error("Bank Detail not found");
            throw new BankDetailsNotFound("Bank details not found");
        }
        Bank bank = bankOptional.get();

        BankTO bankTO = new BankTO();
        bankTO.setBankCode(bank.getBankCode());
        bankTO.setBankName(bank.getBankName());
        bankTO.setBankAddress(bank.getBankAddress());

        log.info("Outside Service Impl.findById");
        return bankTO;
    }

    @Override
    public BankTO findByBankCode(int bankCode) throws BankDetailsNotFound {
        log.info("Inside BankServiceImpl.findByBankCode");
        Optional<Bank> bankOptional1 = bankRepository.findByBankCode(bankCode);

        if (bankOptional1.isEmpty()) {
            log.error("No Details Found");
            throw new BankDetailsNotFound("Bank details not found");
        }

        Bank bank = bankOptional1.get();
        BankTO bankTO = new BankTO();
        bankTO.setBankCode(bank.getBankCode());
        bankTO.setBankName(bank.getBankName());
        bankTO.setBankAddress(bank.getBankAddress());
        log.info("outside BankServiceImpl.findByBankCode");
        return bankTO;
    }

    @Override
    public BankTO save(BankRequest bankRequest) throws BankDetailsNotFound{
        log.info("Inside BankServiceImpl.save");

        Bank bank1= new Bank();
        bank1.setBankCode(bankRequest.getBankCode());
        bank1.setBankName(bankRequest.getBankName());
        bank1.setBankAddress(bankRequest.getBankAddress());

        Bank bank = bankRepository.save(bank1);

        if(Objects.isNull(bank)){
            log.error("Bank Details not found");
            throw new BankDetailsNotFound("Bank details not found");
        }

        BankTO bankTO= new BankTO();
        bankTO.setBankCode(bank.getBankCode());
        bankTO.setBankName(bank.getBankName());
        bankTO.setBankAddress(bank.getBankAddress());
        log.info("Outside BankServiceImpl.save");
         return bankTO;
    }

    @Override
    public String delete(String id) throws BankDetailsNotFound {
        log.info("Inside BankController.delete");
        Optional<Bank> bankOptional= bankRepository.findById(id);
        if(bankOptional.isEmpty()) {
            log.error("Bank details not found");
            throw new BankDetailsNotFound("Bank details not found");
        }
        bankRepository.deleteById(id);
        String msg= "Record has been deleted";
        log.info("Outside AccountServiceImpl.delete");
        return msg;
    }
}

