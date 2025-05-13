package com.practice.spring_mongo.BankingAPI.controller;

import com.practice.spring_mongo.BankingAPI.exception.BankDetailsNotFound;
import com.practice.spring_mongo.BankingAPI.model.BankRequest;
import com.practice.spring_mongo.BankingAPI.model.BankTO;
import com.practice.spring_mongo.BankingAPI.service.BankService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping
    public ResponseEntity<List<BankTO>> getAllBanks() throws BankDetailsNotFound {
        log.info("Inside BankController.findAll Class");
        List<BankTO> bankTOS = bankService.findAll();
        log.info("End Of BankController.findAll");
        return new ResponseEntity<>(bankTOS, HttpStatus.OK);
    }

    //http://127.0.0.1:8080/api/v1/banks/1
    //http://127.0.0.1:8080/api/v1/banks?id=1  @RequestParam("id") String id

    @GetMapping("/{id}")
    public ResponseEntity<BankTO> getBankById (@PathVariable("id") String id) throws BankDetailsNotFound {
        log.info("Inside BankController.findById");
        BankTO bankTO = bankService.findById(id);
        log.info("End of BankController.findById");
        return new ResponseEntity<>(bankTO, HttpStatus.OK);
    }

    @GetMapping("/bankCode")
    public ResponseEntity<BankTO> getBankCode(@RequestParam("bankCode") int bankCode) throws BankDetailsNotFound {
        log.info("Inside BankController.findByBankCode");
        BankTO bankTO= bankService.findByBankCode(bankCode);
        log.info("Outside BankController.findByBankCode");
        return new ResponseEntity<>(bankTO,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BankTO> save (@RequestBody @Valid BankRequest bankRequest) throws BankDetailsNotFound {
        log.info("Inside BankController.save methods");
        BankTO bankTO= bankService.save(bankRequest);
        log.info("Outside BankController.save");
        return new ResponseEntity<>(bankTO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable("id") String id) throws BankDetailsNotFound {
        log.info("Inside BankController.delete");
        String msg= bankService.delete(id);
        log.info("Outside BankController.delete");
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    

}
