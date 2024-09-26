package com.semicolon.africa.arahasubcriptionapp.exception;

public class EmailAlreadyExist extends RuntimeException {
    public EmailAlreadyExist(String response) {
        super(response);
    }
}
