package com.nie.csd.Exceptions;

// General custom exceptions for the e-commerce application
public class GeneralExceptions {

	// Thrown when a product is not found
	public static class ProductNotFoundException extends RuntimeException {
		public ProductNotFoundException(String id) {
			super("Product with ID '" + id + "' not found.");
		}
	}

	// Thrown when product data is invalid
	public static class InvalidProductException extends RuntimeException {
		public InvalidProductException(String message) {
			super(message);
		}
	}

	// Thrown when a product is out of stock
	public static class OutOfStockException extends RuntimeException {
		public OutOfStockException(String productName) {
			super("Product '" + productName + "' is out of stock.");
		}
	}

	// Thrown when a user is not authorized to perform an action
	public static class UnauthorizedActionException extends RuntimeException {
		public UnauthorizedActionException(String message) {
			super(message);
		}
	}

	// Thrown for general bad requests
	public static class BadRequestException extends RuntimeException {
		public BadRequestException(String message) {
			super(message);
		}
	}
}
