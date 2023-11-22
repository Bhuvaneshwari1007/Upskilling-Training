package com.book.exception;

@SuppressWarnings("serial")
public class SequenceException extends Exception {

	public SequenceException() {
		super();
	}

	public SequenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SequenceException(String message, Throwable cause) {
		super(message, cause);
	}

	public SequenceException(String message) {
		super(message);
	}

	public SequenceException(Throwable cause) {
		super(cause);
	}
	
}
