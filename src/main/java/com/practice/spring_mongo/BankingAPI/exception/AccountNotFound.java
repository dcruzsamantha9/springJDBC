package com.practice.spring_mongo.BankingAPI.exception;

public class AccountNotFound extends Exception {
    public AccountNotFound() {
    }

    public AccountNotFound(String message) {
        super(message);
    }

    public AccountNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountNotFound(Throwable cause) {
        super(cause);
    }

    public AccountNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
