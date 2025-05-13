package com.practice.spring_mongo.BankingAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountRequest {
    private int accNo;

    @NotNull
    private String accType;

    @NotNull
    private int accBalance;
}
