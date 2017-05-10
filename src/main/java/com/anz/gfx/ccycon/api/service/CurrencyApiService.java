package com.anz.gfx.ccycon.api.service;

import java.util.List;

import com.anz.gfx.ccycon.exception.NotFoundCurrencyException;
import com.anz.gfx.ccycon.exception.NotFoundException;
import com.anz.gfx.ccycon.model.Currency;

public interface CurrencyApiService {

	List<Currency> findAllCurrency() throws NotFoundException;
	Currency updateCurrency(Currency currency) throws NotFoundException;
	Currency addCurrency(Currency currency) throws NotFoundException;
	Currency findByIdCurrency(Integer id) throws NotFoundException;
	void deleteCurrency(Integer id) throws NotFoundException;

	Currency findByCurrencycode(String ccyCode) throws NotFoundCurrencyException;

	
}
