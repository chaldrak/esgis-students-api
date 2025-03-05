package com.cwa.crudspringboot.exceptions;

public class NotFoundEntityException extends RuntimeException{
    public NotFoundEntityException() {
    }

    public NotFoundEntityException(String message) {
        super(message);
    }
}
