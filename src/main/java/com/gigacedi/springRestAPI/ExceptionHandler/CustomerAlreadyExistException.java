package com.gigacedi.springRestAPI.ExceptionHandler;

public class CustomerAlreadyExistException extends RuntimeException{

    public CustomerAlreadyExistException() {
    }

    public CustomerAlreadyExistException(String message) {

        super(message);
    }

    public CustomerAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
