package com.xwolf.eop.common.security.csrf.exception;

/**
 * 
 * Exception thrown when a CSRF validation fails.
 * 
 * @author Rafael Pinto
 *
 */
public class CsrfException extends Exception {

	private static final long serialVersionUID = -2753249576880065192L;

	public CsrfException(String message, Throwable cause) {
		super(message, cause);
	}

	public CsrfException(String message) {
		super(message);
	}

}
