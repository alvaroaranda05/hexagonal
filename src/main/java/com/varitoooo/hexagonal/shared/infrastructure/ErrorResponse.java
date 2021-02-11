package com.varitoooo.hexagonal.shared.infrastructure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
    private final Integer status;
    private final String error;
    private final String message;
    private final Instant timestamp;

    public ErrorResponse(HttpStatus status, String errorMessage) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = errorMessage;
        this.timestamp = Instant.now();
    }


    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
