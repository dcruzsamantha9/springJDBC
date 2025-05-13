package com.practice.spring_mongo.BankingAPI.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankTO {
    private int bankCode;
    private String bankName;
    private String bankAddress;
}
