package com.anz.gfx.ccycon.api.service;

import java.util.List;

import com.anz.gfx.ccycon.exception.NotFoundException;
import com.anz.gfx.ccycon.model.Dailycurrency;

public interface DailycurrencyApiService {

	List<Dailycurrency> findAllDailycurrency() throws NotFoundException;
	Dailycurrency updateDailycurrency(Dailycurrency dailycurrency) throws NotFoundException;
	Dailycurrency addDailycurrency(Dailycurrency dailycurrency) throws NotFoundException;
	Dailycurrency findByIdDailycurrency(Integer id) throws NotFoundException;
	void deleteDailycurrency(Integer id) throws NotFoundException;

}
