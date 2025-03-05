package com.cwa.crudspringboot.advisers;

import com.cwa.crudspringboot.exceptions.NotFoundStudentException;
import com.cwa.crudspringboot.exceptions.PasswordAndConfirmedNotEqualException;
import com.cwa.crudspringboot.payloads.responses.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return new ResponseEntity(new StandardResponse("500", "Error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NotFoundStudentException.class})
    public ResponseEntity handleNotFoundException(NotFoundStudentException e) {
        return new ResponseEntity(new StandardResponse("404", "Error", e.getMessage()), HttpStatus.NOT_FOUND);
    }

   @ExceptionHandler(PasswordAndConfirmedNotEqualException.class)
    public ResponseEntity handleValidationException(PasswordAndConfirmedNotEqualException e) {
        return new ResponseEntity(new StandardResponse("400", "Error", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}