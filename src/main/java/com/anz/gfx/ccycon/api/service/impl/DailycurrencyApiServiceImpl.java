package com.anz.gfx.ccycon.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anz.gfx.ccycon.api.service.DailycurrencyApiService;
import com.anz.gfx.ccycon.exception.NotFoundCurrencyException;
import com.anz.gfx.ccycon.exception.NotFoundException;
import com.anz.gfx.ccycon.model.Dailycurrency;
import com.anz.gfx.ccycon.model.repository.DailycurrencyRepository;

@Service
@Transactional
public class DailycurrencyApiServiceImpl implements DailycurrencyApiService {

	@Autowired
	private DailycurrencyRepository dailycurrencyRepository;

	@Override
	public List<Dailycurrency> findAllDailycurrency() throws NotFoundException {

		return dailycurrencyRepository.findAll();

	}

	@Override
	public Dailycurrency updateDailycurrency(Dailycurrency dailycurrency) throws NotFoundException {

		return dailycurrencyRepository.save(dailycurrency);

	}

	@Override
	public Dailycurrency addDailycurrency(Dailycurrency dailycurrency) 
			throws NotFoundException, NotFoundCurrencyException {

		
		/*Currency frmCcy = dailycurrency.getFrmccy();
		Currency toCcy = dailycurrency.getToccy();
		if(frmCcy == null  || toCcy == null) {
			throw new NotFoundCurrencyException("Unknown Currency");
		}
		String frmCcyCode = frmCcy.getCurrencycode();
		String toCcyCode = toCcy.getCurrencycode();*/
		
		
		return dailycurrencyRepository.save(dailycurrency);

	}

	@Override
	public Dailycurrency findByIdDailycurrency(Integer id) throws NotFoundException {

		return dailycurrencyRepository.findOne(id);

	}

	@Override
	public void deleteDailycurrency(Integer id) throws NotFoundException {

	}
	
	

}


class CurrencyUnit {
	
	/**
	 * Converts one currency to another currency with real time exchange rate
	 */
	
    //String getCurrencyCode();

	
}