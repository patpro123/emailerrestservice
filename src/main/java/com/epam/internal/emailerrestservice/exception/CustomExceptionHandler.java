package com.epam.internal.emailerrestservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Controller
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler{

	public CustomExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		Error error = new Error(ex.getMessage(),request.getDescription(false));
		ResponseEntity resp = new ResponseEntity(error,HttpStatus.INTERNAL_SERVER_ERROR);
		return resp;
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {

		String [] error = ex.getMessage().split(",");
		ResponseEntity resp = new ResponseEntity(new Error(error[0],error[1]),HttpStatus.NOT_FOUND);
		return resp;
		
	}

}
