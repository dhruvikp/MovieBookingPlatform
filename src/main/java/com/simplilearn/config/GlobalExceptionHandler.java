package com.simplilearn.config;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simplilearn.exceptions.MovieNotFoundException;

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
	
	@ExceptionHandler(value = MovieNotFoundException.class)
	@ResponseBody
	public String handleMovieNotFoundException() {
		return "Specified movie not found in DB!";
	}
}
