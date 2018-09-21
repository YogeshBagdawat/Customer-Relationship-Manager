package com.crm.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomizeExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public String handleExceptionE(Model model,Exception e) {
		
		return "exception";
		
	}
	
	@ExceptionHandler(value=NullPointerException.class)
	public String handleException(Model model,Exception e) {
		
		return "exception";
		
	}
	
	@ExceptionHandler(value=ArithmeticException.class)
	public String handleExceptionA(Model model,Exception e) {
		
		return "exception";
		
	}
}
