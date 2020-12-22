package com.mile.bank.loginApplication.application;

public class PasswordWrongException extends RuntimeException{
    PasswordWrongException() {
        super("Password is wrong");
    };
}
