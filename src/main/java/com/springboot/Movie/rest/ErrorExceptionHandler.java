package com.springboot.Movie.rest;

public class ErrorExceptionHandler extends RuntimeException{
    public ErrorExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ErrorExceptionHandler(Throwable cause) {
        super(cause);
    }

    public ErrorExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorExceptionHandler(String message) {
        super(message);
    }

    public ErrorExceptionHandler() {
    }
}
