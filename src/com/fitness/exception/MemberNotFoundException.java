package com.fitness.exception;

public class MemberNotFoundException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MemberNotFoundException(String message) {
        super(message);
    }
}
