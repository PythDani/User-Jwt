package com.shopsusers.exceptionHandler;

public class ResourceBadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceBadRequestException(String message) {
        super(message);
    }
}
