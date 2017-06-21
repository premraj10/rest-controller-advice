package com.example.restcontrolleradvice.exception;

public class NotFoundException extends RuntimeException {

	public NotFoundException(final String message)
	{
		super(message);
	}
}