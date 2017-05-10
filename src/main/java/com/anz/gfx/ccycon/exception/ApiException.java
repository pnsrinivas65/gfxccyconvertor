package com.anz.gfx.ccycon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ApiException extends Exception {
	private static final long serialVersionUID = 1L;
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
