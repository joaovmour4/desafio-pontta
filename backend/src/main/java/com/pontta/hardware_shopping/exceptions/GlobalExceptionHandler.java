package com.pontta.hardware_shopping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<RestMessageException> emailAlreadyExistsExceptionHandler(EmailAlreadyExistsException exception){

        RestMessageException restMessage = new RestMessageException(exception.getMessage());

        return new ResponseEntity<>(restMessage, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RestMessageException> ResourceNotFoundException(ResourceNotFoundException exception){

        RestMessageException restMessage = new RestMessageException(exception.getMessage());

        return new ResponseEntity<>(restMessage, HttpStatus.BAD_REQUEST);

    }

}
