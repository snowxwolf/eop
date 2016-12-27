package com.xwolf.eop.common.security.csrf.exception;

/**
 * 
 * Exception thrown when an error occurs encrypting/decrypting data.
 * 
 * @author Rafael Pinto
 *
 */
public class EncryptionException extends RuntimeException {

	private static final long serialVersionUID = -2753249576880065192L;

	public EncryptionException(String message, Throwable cause) {
		super(message, cause);
	}

	public EncryptionException(String message) {
		super(message);
	}

}
