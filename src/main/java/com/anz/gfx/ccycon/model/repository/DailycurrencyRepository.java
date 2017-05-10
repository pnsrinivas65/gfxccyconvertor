package com.anz.gfx.ccycon.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.gfx.ccycon.model.Dailycurrency;




@Repository
public interface DailycurrencyRepository extends JpaRepository<Dailycurrency, Integer>{

}



