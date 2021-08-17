package com.springRest.contacts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ContactExceptionController {	// used to handle exception globally
	@ResponseBody	// signals that advice should be rendered straight into the response
	@ExceptionHandler(value = ContactNotFoundException.class)	// configure advice for this exception
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String contactNotFoundHandler(ContactNotFoundException ex) {
		return ex.getMessage();
	}
}
