package com.learning.app.exceptionHandler;


import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	Logger logger = LoggerFactory.logger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public String handleNotFoundException(Model model, Exception ex) {
		logger.error(ex.getMessage());
		model.addAttribute("error", ex.getLocalizedMessage());
		return "error-page";
	}

}
