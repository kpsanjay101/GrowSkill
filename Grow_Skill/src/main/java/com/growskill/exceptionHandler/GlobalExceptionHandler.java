package com.growskill.exceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionFormate> noHandlerFoundException(NoHandlerFoundException ex, WebRequest wr){
		
		ExceptionFormate ef = new ExceptionFormate(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<ExceptionFormate>(ef, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionFormate> noSuchElementException(NoSuchElementException ex, WebRequest wr){
		
		ExceptionFormate ef = new ExceptionFormate(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<ExceptionFormate>(ef, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseAllReadyExistException.class)
	public ResponseEntity<ExceptionFormate> courseAllReadyExistException(CourseAllReadyExistException ex, WebRequest wr){
		
		ExceptionFormate ef = new ExceptionFormate(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<ExceptionFormate>(ef, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ExceptionFormate> courseNotFoundException(CourseNotFoundException ex, WebRequest wr){
		
		ExceptionFormate ef = new ExceptionFormate(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<ExceptionFormate>(ef, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ExceptionFormate> customerNotFoundException(CustomerNotFoundException ex, WebRequest wr){
		
		ExceptionFormate ef = new ExceptionFormate(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<ExceptionFormate>(ef, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InstructorNotFoundException.class)
    public ResponseEntity<ExceptionFormate> instructorNotFoundException(InstructorNotFoundException ex, WebRequest wr){
		
		ExceptionFormate ef = new ExceptionFormate(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<ExceptionFormate>(ef, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PaymentException.class)
    public ResponseEntity<ExceptionFormate> paymentException(PaymentException ex, WebRequest wr){
		
		ExceptionFormate ef = new ExceptionFormate(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<ExceptionFormate>(ef, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionFormate> allExceptionHandle(Exception ex, WebRequest wr){
		
		ExceptionFormate ef = new ExceptionFormate(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<ExceptionFormate>(ef, HttpStatus.NOT_FOUND);
	}

}
