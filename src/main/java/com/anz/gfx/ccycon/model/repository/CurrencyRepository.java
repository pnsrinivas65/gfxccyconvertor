package com.anz.gfx.ccycon.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.gfx.ccycon.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

	
	public Currency findByCurrencycode(String ccyCode);
	
}
