package com.varitoooo.hexagonal.shared.infrastructure;


import com.varitoooo.hexagonal.shared.domain.exception.InvalidEntityException;
import com.varitoooo.hexagonal.shared.domain.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;


@ControllerAdvice
@RestController
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleOtherExceptions(Exception ex, WebRequest request) {
        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, request, ex);
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex, WebRequest request) {
        return handleException(HttpStatus.NOT_FOUND, request, ex);
    }

    @ExceptionHandler(InvalidEntityException.class)
    protected ResponseEntity<ErrorResponse> handleInvalidEntityException(InvalidEntityException ex, WebRequest request) {
        return handleException(HttpStatus.BAD_REQUEST, request, ex);
    }

    protected ResponseEntity<ErrorResponse> handleException(HttpStatus status, WebRequest request, Exception ex) {
        ErrorResponse body = new ErrorResponse(status, ex.getMessage());
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);

        return new ResponseEntity<>(body, new HttpHeaders(), status);
    }
}
