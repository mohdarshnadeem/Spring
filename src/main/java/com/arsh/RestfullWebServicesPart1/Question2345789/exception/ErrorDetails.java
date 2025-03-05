package com.arsh.RestfullWebServicesPart1.Question2345789.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private String message;
    private LocalDateTime localDateTime;
    private String details;

    public ErrorDetails(String message, LocalDateTime localDateTime, String details) {
        this.message = message;
        this.localDateTime = localDateTime;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "message='" + message + '\'' +
                ", localDateTime=" + localDateTime +
                ", details='" + details + '\'' +
                '}';
    }
}
