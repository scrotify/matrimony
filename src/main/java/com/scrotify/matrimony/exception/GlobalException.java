package com.scrotify.matrimony.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{
		  @ExceptionHandler(MatrimonyException.class) public
		  ResponseEntity<ErrorResponse> ecomorseExceptionHandler(MatrimonyException ex,WebRequest request) {
			  ErrorResponse errorResponse = new ErrorResponse();
			  errorResponse.setMessage(ex.getMessage());
			  errorResponse.setStatusCode(401);
		  
		  return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		  
		  }
		 
		  
		  @ExceptionHandler(Exception.class)
			public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception exception, WebRequest request) {
				 ErrorResponse errorResponse = new ErrorResponse();
				  errorResponse.setMessage(exception.getMessage());

				return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

			}

	}


