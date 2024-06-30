package com.mindgate.main.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class EmployeeTravelExceptionHandler 
{	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView AnyOtherHandler(Exception exception)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("err","Exception ::"+ exception.getMessage());
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
