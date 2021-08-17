package com.springRest.contacts.exception;

public class ContactNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8081433429565686521L;

	public ContactNotFoundException(Long id) {
		super("Could not find contact " + id);
	}
}
