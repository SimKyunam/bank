package com.mile.bank.loginApplication.interfaces;

import lombok.Data;

@Data
public class SessionRequestDto {

    private String email;

    private String password;
}
