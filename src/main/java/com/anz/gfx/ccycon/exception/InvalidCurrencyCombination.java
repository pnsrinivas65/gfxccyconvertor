package com.anz.gfx.ccycon.exception;

import java.util.Locale;
import java.util.Objects;

public class InvalidCurrencyCombination extends CcyConversion {

	private static final long serialVersionUID = 5903607414938564200L;
	
	/** The invalid currency code requested. */
	private final String currencyCode;
	private final Locale locale;

	public InvalidCurrencyCombination(String code) {
		super("Wrong or Invalid Currency used: " + code);
		this.currencyCode = code;
		this.locale = null;
	}

	public InvalidCurrencyCombination(Locale locale) {
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
			return "Wrong or Invalid Currency used: [currencyCode=" + currencyCode + "]";
		} else {
			return "Wrong or Invalid Currency used: [locale=" + locale + "]";
		}
	}

}
