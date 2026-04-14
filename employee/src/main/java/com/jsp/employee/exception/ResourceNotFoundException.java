package com.jsp.employee.exception;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String message) {
        super(message);
    }

}
