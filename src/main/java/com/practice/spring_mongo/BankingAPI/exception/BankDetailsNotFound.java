package com.practice.spring_mongo.BankingAPI.exception;

public class BankDetailsNotFound extends Exception {
    public BankDetailsNotFound() {
    }

    public BankDetailsNotFound(String message) {
        super(message);
    }

    public BankDetailsNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BankDetailsNotFound(Throwable cause) {
        super(cause);
    }

    public BankDetailsNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
