package com.practice.spring_mongo.BankingAPI.controller;


import com.practice.spring_mongo.BankingAPI.exception.AccountNotFound;
import com.practice.spring_mongo.BankingAPI.model.AccountRequest;
import com.practice.spring_mongo.BankingAPI.model.AccountTO;
import com.practice.spring_mongo.BankingAPI.service.AccountService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountTO>> getAllAccounts() throws AccountNotFound {
        log.info("Inside AccountController.findAll");
        List<AccountTO> accountTOS= accountService.getAllAccount();
        log.info("Outside AccountController.findAll");
        return new ResponseEntity<>(accountTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountTO> getByAccId(@PathVariable("id") String id) throws AccountNotFound{
        log.info("Inside AccountController.getById");
        AccountTO accountTO = accountService.findByAccId(id);
        log.info("Outside AccountController.getById");
        return new ResponseEntity<>(accountTO, HttpStatus.OK);
    }

    @GetMapping("/accNo")
    public ResponseEntity<AccountTO> getbyAccNo(@RequestParam("accNo") int accNo) throws AccountNotFound{
        log.info("Inside AccountController.findByAccNo");
        AccountTO accountTO= accountService.findByAccNo(accNo);
        log.info("Outside AccountController.findByAccNo");
        return new ResponseEntity<>(accountTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountTO> save(@RequestBody @Valid AccountRequest accountRequest) throws AccountNotFound{
        log.info("Inside AccountController.save");
        AccountTO accountTO= accountService.save(accountRequest);
        log.info("Outside AccountController.save");
        return new ResponseEntity<>(accountTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@RequestParam("id") String id) throws AccountNotFound{
        log.info("Inside AccountController.delete");
        String msg= accountService.delete(id);
        log.info("Outside AccountController.delete");
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
