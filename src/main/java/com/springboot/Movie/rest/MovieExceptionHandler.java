package com.springboot.Movie.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.InputMismatchException;

@ControllerAdvice
public class MovieExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> IdNotFoundException(IllegalArgumentException ex){
        ErrorResponse e = new ErrorResponse();
        e.setStatus(HttpStatus.NOT_FOUND.value());
        e.setMessage(ex.getMessage());
        e.setTime(System.currentTimeMillis());
        return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> IdNotFoundException(RuntimeException ex){
        ErrorResponse e = new ErrorResponse();
        e.setStatus(HttpStatus.BAD_REQUEST.value());
        e.setMessage(ex.getMessage());
        e.setTime(System.currentTimeMillis());
        return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> ratingInvalidException(InputMismatchException inpex){
        ErrorResponse e = new ErrorResponse();
        e.setStatus(HttpStatus.BAD_REQUEST.value());
        e.setMessage(inpex.getMessage());
        e.setTime(System.currentTimeMillis());
        return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
    }

}
