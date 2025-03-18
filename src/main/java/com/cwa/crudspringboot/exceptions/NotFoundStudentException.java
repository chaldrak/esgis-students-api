package com.cwa.crudspringboot.exceptions;

public class NotFoundStudentException extends NotFoundEntityException {
    public NotFoundStudentException() {
    }

    public NotFoundStudentException(String message) {
        super(message);
    }
}
