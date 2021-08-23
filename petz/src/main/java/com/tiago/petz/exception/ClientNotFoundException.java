package com.tiago.petz.exception;

public class ClientNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public ClientNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
