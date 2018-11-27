package com.propia.sgdm.service.errors.exceptions;

public class BaseException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5409972185887072176L;

	public BaseException(String messageException) {
		super(messageException);
	}

}
