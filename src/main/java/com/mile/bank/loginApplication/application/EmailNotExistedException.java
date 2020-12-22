package com.mile.bank.loginApplication.application;

public class EmailNotExistedException extends RuntimeException {

    EmailNotExistedException(String email){
        super("Email is not registered: "+email);
    }
}
