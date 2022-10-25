package com.enexse.test.exceptions;

public class ResourceNotFindException extends RuntimeException {
private static final long serialVersionUID = 1L;
	 
	public ResourceNotFindException(String message) {
		super(message);
	}
}
