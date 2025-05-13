package com.practice.spring_mongo.BankingAPI.repository;

import com.practice.spring_mongo.BankingAPI.entity.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface BankRepository extends MongoRepository<Bank, String> {
    Optional<Bank> findByBankCode(@Param("bankCode") int code);
}
