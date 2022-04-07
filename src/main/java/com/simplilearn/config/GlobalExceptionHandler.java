package com.simplilearn.config;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String arithmaticExceptionHandler() {
		return "Internal error occurred";
	}

	@ExceptionHandler(value = ArithmeticException.class)
	@ResponseBody
	public String arithmaticExceptionHandler1() {
		return "Arithmatic Exception Occurred";
	}
}
