package com.techsupport.api.errors.handlers;

import com.techsupport.api.errors.exceptions.PersonNotFoundExeption;
import com.techsupport.api.errors.responses.PersonErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundExeption e){
        PersonErrorResponse error = new PersonErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PersonErrorResponse> handleException(Exception e){
        PersonErrorResponse error = new PersonErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
