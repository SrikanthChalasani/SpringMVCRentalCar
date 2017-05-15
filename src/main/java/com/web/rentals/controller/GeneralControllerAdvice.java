package com.web.rentals.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GeneralControllerAdvice {

	@ExceptionHandler(RuntimeException.class)
	public ModelAndView handleException(RuntimeException ex) {
		Logger logger = Logger.getLogger(this.getClass().getName());
		logger.error(ex.getMessage());
		return new ModelAndView("exception", "exception", ex);
	}
}
