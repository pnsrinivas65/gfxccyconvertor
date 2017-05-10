package com.anz.gfx.ccycon.exception;

import java.util.Locale;
import java.util.Objects;

public class NotFoundCurrencyException extends CcyConversion {

	private static final long serialVersionUID = 5903607414938564200L;
	
	/** The invalid currency code requested. */
	private final String currencyCode;
	private final Locale locale;

	public NotFoundCurrencyException(String code) {
		super("Unknown currency code: " + code);
		this.currencyCode = code;
		this.locale = null;
	}

	public NotFoundCurrencyException(Locale locale) {
		super("No currency for found for Locale: " + locale);
		this.locale = locale;
		this.currencyCode = null;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public Locale getLocale() {
		return locale;
	}

	@Override
	public String toString() {
		if (Objects.isNull(locale)) {
			return "NotFoundCurrencyException [currencyCode=" + currencyCode + "]";
		} else {
			return "NotFoundCurrencyException [locale=" + locale + "]";
		}
	}

}
