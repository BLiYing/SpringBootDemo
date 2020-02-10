package com.example.demo.exception;


import com.example.demo.pojo.IMoocJSONResult;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class IMoocAjaxExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
	public IMoocJSONResult defaultErrorHandler(HttpServletRequest req, 
			Exception e) throws Exception {

		e.printStackTrace();
		return IMoocJSONResult.errorException(e.getMessage());
	}
}
