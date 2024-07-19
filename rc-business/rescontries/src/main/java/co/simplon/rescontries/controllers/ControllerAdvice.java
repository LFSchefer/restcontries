package co.simplon.rescontries.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	    HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	System.out.println("ControllerAdvice.handleMethodArgumentNotValid()");
	List<FieldError> error = ex.getFieldErrors();
	List<CustomFieldError> customErrors = new ArrayList<>();
	for (FieldError fieldError : error) {
	    String fieldName = fieldError.getField();
	    String fieldCode = fieldError.getCode();
	    CustomFieldError customFieldError = new CustomFieldError(fieldName, fieldCode);
	    customErrors.add(customFieldError);
	}

	return handleExceptionInternal(ex, customErrors, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
	    HttpStatusCode statusCode, WebRequest request) {
	System.out.println("ControllerAdvice.handleExceptionInternal()");
	return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }
}
