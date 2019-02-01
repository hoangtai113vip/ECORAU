package com.example.freetuts.rest;

public class FreetutNotFoundException extends RuntimeException {

	public FreetutNotFoundException() {
	}

	public FreetutNotFoundException(String message) {
		super(message);
	}

	public FreetutNotFoundException(Throwable cause) {
		super(cause);
	}

	public FreetutNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FreetutNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
