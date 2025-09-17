package com.nie.csd.Exceptions;

public class IdNotPresentException extends RuntimeException {
	public IdNotPresentException(String id) {
		super("Product with ID '" + id + "' not found.");
	}
}
