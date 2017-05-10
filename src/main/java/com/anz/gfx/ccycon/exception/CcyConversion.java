package com.anz.gfx.ccycon.exception;


/**
 * Exception For currency conversion.
 * 
 */
public class CcyConversion extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2439557890113487162L;

	public CcyConversion(String message) {
		super(message);
	}

	public CcyConversion(String message, Throwable cause) {
		super(message, cause);
	}
}
