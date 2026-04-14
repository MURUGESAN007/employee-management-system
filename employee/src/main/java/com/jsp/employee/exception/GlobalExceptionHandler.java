package com.jsp.employee.exception;

import java.util.*;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
    public Map<String, String> handle(ResourceNotFoundException ex) {
        return Map.of("error", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Map<String, String> handleAll(Exception ex) {
        return Map.of("error", ex.getMessage());
    }
}