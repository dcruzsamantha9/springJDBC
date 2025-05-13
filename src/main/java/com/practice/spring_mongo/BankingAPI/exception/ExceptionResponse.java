package com.practice.spring_mongo.BankingAPI.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {
    private String errorMessage;
    private String requestedURI;
}
