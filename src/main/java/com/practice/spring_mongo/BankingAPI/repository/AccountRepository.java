package com.practice.spring_mongo.BankingAPI.repository;

import com.practice.spring_mongo.BankingAPI.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {
    Optional<Account> findByAccNo(@Param("accNo") int accNo);
}
