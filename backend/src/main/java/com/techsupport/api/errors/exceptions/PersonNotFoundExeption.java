package com.techsupport.api.errors.exceptions;

public class PersonNotFoundExeption extends RuntimeException{
    public PersonNotFoundExeption(String message) {
        super(message);
    }

    public PersonNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonNotFoundExeption(Throwable cause) {
        super(cause);
    }
}
