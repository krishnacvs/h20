package com.labs.h20.exception;

import org.springframework.http.HttpStatus;

public class CountryException extends Exception{

    private HttpStatus errorStatus;
    private String errorMessage;

    public CountryException() {
        super();
    }

    public CountryException(String errorMessage, HttpStatus errorStatus) {
        super(errorMessage);
        this.errorStatus = errorStatus;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getErrorStatus() {
        return errorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
