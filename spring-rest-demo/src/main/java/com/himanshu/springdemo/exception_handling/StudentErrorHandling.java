package com.himanshu.springdemo.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.himanshu.springdemo.strings.StudentStrings;

@ControllerAdvice
public class StudentErrorHandling implements StudentStrings{
//	add exception handler which is going to handle the exception generated
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentExceptionHandling exe){
		
//		create student error response
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setId(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(loadStudent_exception);
		errorResponse.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e){
		
//		create error response for general type of errors
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setId(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(loadStudent_exception);
		errorResponse.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
