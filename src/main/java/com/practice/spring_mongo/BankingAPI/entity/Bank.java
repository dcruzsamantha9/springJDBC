package com.practice.spring_mongo.BankingAPI.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "t_bank")
public class Bank {
    @Indexed @Id
    private String id;
    @Field(name = "bankCode")
    private int bankCode;
    @Field(name = "bankName")
    private String bankName;
    @Field(name="bankAddress")
    private String bankAddress;
}
