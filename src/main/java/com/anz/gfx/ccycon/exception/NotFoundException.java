package com.anz.gfx.ccycon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends ApiException {
	private static final long serialVersionUID = 1L;
	private int code;

	public NotFoundException(int code, String msg) {
		super(code, msg);
		this.code = code;
	}
}
