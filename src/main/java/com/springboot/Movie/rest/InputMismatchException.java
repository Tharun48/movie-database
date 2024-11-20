package com.springboot.Movie.rest;

public class InputMismatchException extends  RuntimeException{
    public InputMismatchException() {
    }

    public InputMismatchException(String message) {
        super(message);
    }

    public InputMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputMismatchException(Throwable cause) {
        super(cause);
    }

    public InputMismatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
