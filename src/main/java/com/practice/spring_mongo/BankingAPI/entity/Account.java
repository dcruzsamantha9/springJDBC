package com.practice.spring_mongo.BankingAPI.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "t_account")
public class Account {
    @Id @Indexed
    private String id;
    @Field(name = "accNo")
    private int accNo;
    @Field(name = "accType")
    private String accType;
    @Field(name = "accBalance")
    private int accBalance;
}
