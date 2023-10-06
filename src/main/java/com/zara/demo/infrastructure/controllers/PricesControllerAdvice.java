package com.zara.demo.infrastructure.controllers;

import com.zara.demo.infrastructure.exception.PricesNotFoundException;
import com.zara.demo.infrastructure.exception.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class PricesControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
	List<String> errors = new ArrayList<>();
	for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	    errors.add(error.getDefaultMessage());
	}
	for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
	    errors.add(error.getDefaultMessage());
	}

	ValidationErrorResponse errorResponse = new ValidationErrorResponse(errors);
	return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PricesNotFoundException.class)
    public ResponseEntity<ValidationErrorResponse> handlerPriceSNotFoundException(PricesNotFoundException exception){
	List<String> errors = List.of(exception.getMessage());

	return ResponseEntity.badRequest().body(ValidationErrorResponse.builder().errors(errors).build());
    }
}
