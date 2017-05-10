package com.anz.gfx.ccycon.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anz.gfx.ccycon.api.service.CurrencyApiService;
import com.anz.gfx.ccycon.exception.NotFoundCurrencyException;
import com.anz.gfx.ccycon.exception.NotFoundException;
import com.anz.gfx.ccycon.model.Currency;
import com.anz.gfx.ccycon.model.repository.CurrencyRepository;

@Service
@Transactional
public class CurrencyApiServiceImpl implements CurrencyApiService {

	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	public List<Currency> findAllCurrency() throws NotFoundException {
		return currencyRepository.findAll();

	}

	@Override
	public Currency updateCurrency(Currency currency) throws NotFoundException {
		return currencyRepository.save(currency);

	}

	@Override
	public Currency addCurrency(Currency currency) throws NotFoundException {
		return currencyRepository.save(currency);

	}

	@Override
	public Currency findByIdCurrency(Integer id) throws NotFoundException {
		return currencyRepository.findOne(id);

	}

	@Override
	public void deleteCurrency(Integer id) throws NotFoundException {

	}

	@Override
	public Currency findByCurrencycode(String ccyCode) throws NotFoundCurrencyException {
		
		return currencyRepository.findByCurrencycode(ccyCode);
	}

}
