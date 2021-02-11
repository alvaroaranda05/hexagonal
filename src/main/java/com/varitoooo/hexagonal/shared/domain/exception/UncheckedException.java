package com.varitoooo.hexagonal.shared.domain.exception;

import javax.validation.ValidationException;

public abstract class UncheckedException extends RuntimeException {

    private String message;
    private Throwable originalException = this;


    public UncheckedException(Throwable cause) {
        super(cause);
        setMessage(cause);
        setOriginalException(cause);
    }


    public UncheckedException(String message) {
        super(message);
        this.message = message;
    }


    public UncheckedException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        setOriginalException(cause);
    }


    @Override
    public String getMessage() {
        return this.message;
    }


    private void setMessage(Throwable cause) {
        this.message = getDefaultMessage();

        if (isOwnException(cause)) {
            this.message = cause.getMessage();
        }
    }


    private boolean isOwnException(Throwable cause) {
        return cause instanceof UncheckedException ||
                cause instanceof ValidationException;
    }


    public Throwable getOriginalException() {
        return this.originalException;
    }


    private void setOriginalException(Throwable exception) {
        if (exception instanceof UncheckedException) {
            this.originalException = ((UncheckedException) exception).getOriginalException();
        }
        this.originalException = exception;
    }


    protected abstract String getDefaultMessage();
}
