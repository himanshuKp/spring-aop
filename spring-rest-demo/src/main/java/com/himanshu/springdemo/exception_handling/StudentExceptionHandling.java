package com.himanshu.springdemo.exception_handling;

public class StudentExceptionHandling extends RuntimeException {

	public StudentExceptionHandling(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentExceptionHandling(String message) {
		super(message);
	}

	public StudentExceptionHandling(Throwable cause) {
		super(cause);
	}
	
}
