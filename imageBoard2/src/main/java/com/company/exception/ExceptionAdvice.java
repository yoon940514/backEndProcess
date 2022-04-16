package com.company.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.http.HttpStatus;


import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class ExceptionAdvice {
	// 500에러
	@ExceptionHandler(Exception.class)
	public String except(ExceptionAdvice  ex, Model model) {
			model.addAttribute("exception", ex);
			return "error_page500";
		
	}
	
	// 400에러
		@ExceptionHandler(NoHandlerFoundException.class)
		@ResponseStatus(HttpStatus.NOT_FOUND)
		public String except2(ExceptionAdvice ex, Model model) {
			return "error_page404";
			
	}
}