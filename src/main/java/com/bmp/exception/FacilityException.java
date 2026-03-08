package com.bmp.exception;

public class FacilityException extends Exception {

	private static final long serialVersionUID = -6239080913521128264L;

	public FacilityException() {
		super();
	}

	public FacilityException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FacilityException(String message, Throwable cause) {
		super(message, cause);
	}

	public FacilityException(String message) {
		super(message);
	}

	public FacilityException(Throwable cause) {
		super(cause);
	}
}