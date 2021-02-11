package com.varitoooo.hexagonal.shared.domain.exception;

public class NotFoundException extends UncheckedException {

    private static final String DEFAULT_MESSAGE = "Not Found Exception";


    public NotFoundException(Exception exception) {
        super(exception);
    }


    public NotFoundException(String message) {
        super(message);
    }


    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


    @Override
    protected String getDefaultMessage() {
        return DEFAULT_MESSAGE;
    }
}
