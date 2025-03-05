package com.cwa.crudspringboot.exceptions;

public class PasswordAndConfirmedNotEqualException extends RuntimeException{
    public PasswordAndConfirmedNotEqualException() {
    }

    public PasswordAndConfirmedNotEqualException(String message) {
        super(message);
    }
}
