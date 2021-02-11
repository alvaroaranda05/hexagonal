package com.varitoooo.hexagonal.shared.domain.exception;

public class InvalidEntityException extends UncheckedException {

    private static final String DEFAULT_MESSAGE = "Invalid Entity Exception";


    public InvalidEntityException(Exception exception) {
        super(exception);
    }


    public InvalidEntityException(String message) {
        super(message);
    }


    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }


    @Override
    protected String getDefaultMessage() {
        return DEFAULT_MESSAGE;
    }
}
