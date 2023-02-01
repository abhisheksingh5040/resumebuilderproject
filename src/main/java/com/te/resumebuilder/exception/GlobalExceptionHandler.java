package com.te.resumebuilder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.resumebuilder.reponse.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserProfileIdNotFoundException.class)
	public ResponseEntity<ExceptionResponse> userProfileIdNotFoundException(UserProfileIdNotFoundException exception){
		ExceptionResponse exceptionResponse  = new ExceptionResponse();
		exceptionResponse.setMessage(exception.getMessage());
		exceptionResponse.setStatus(400);
		exceptionResponse.setSuccess(false);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
}
