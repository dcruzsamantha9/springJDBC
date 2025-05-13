package com.practice.spring_mongo.BankingAPI.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BankDetailsNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleBankDetailsNotFound(HttpServletRequest request, BankDetailsNotFound exception){
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleExceptions(HttpServletRequest request, Exception exception){
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        return response;
    }

    @ExceptionHandler(AccountNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleAccountNotFound(HttpServletRequest request, AccountNotFound exception){
        ExceptionResponse response=new ExceptionResponse();
        response.setErrorMessage(exception.getMessage());
        response.setRequestedURI(request.getRequestURI());
        return response;
    }
}
