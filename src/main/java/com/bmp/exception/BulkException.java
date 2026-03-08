package com.bmp.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class BulkException extends Exception implements HandlerExceptionResolver{

	private static final long serialVersionUID = -6239080913521128264L;

	public BulkException() {
		super();
	}

	public BulkException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BulkException(String message, Throwable cause) {
		super(message, cause);
	}

	public BulkException(String message) {
		super(message);
	}

	public BulkException(Throwable cause) {
		super(cause);
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		return null;
	}
}