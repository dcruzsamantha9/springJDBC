package com.practice.spring_mongo.BankingAPI.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountTO {
    private int accNo;
    private String accType;
    private int accBalance;
}
