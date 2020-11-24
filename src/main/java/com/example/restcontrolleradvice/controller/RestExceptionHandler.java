package com.example.restcontrolleradvice.controller;

import com.example.restcontrolleradvice.exception.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


	private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleException(final NotFoundException exception)
    {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(final Exception exception)
    {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
    		HttpHeaders headers, HttpStatus status, WebRequest request) {
    	log.error("406 mediatype not acceptable exception handling {}", ex.getMessage());
    	return super.handleHttpMediaTypeNotAcceptable(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
    		HttpHeaders headers, HttpStatus status, WebRequest request) {
    	// TODO Auto-generated method stub
    	log.error("415 mediatype not supported exception handling {}", ex.getMessage());
    	return super.handleHttpMediaTypeNotSupported(ex, headers, status, request);
    }

}
