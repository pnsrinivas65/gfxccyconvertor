package com.anz.gfx.ccycon.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anz.gfx.ccycon.api.service.CurrencyApiService;
import com.anz.gfx.ccycon.exception.NotFoundException;
import com.anz.gfx.ccycon.model.Currency;

@RestController
@RequestMapping(value = "/api")
public class CurrencyApi {

	@Autowired
	private CurrencyApiService service;

	@RequestMapping(value = "/currency", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.GET)
	public ResponseEntity<List<Currency>> findAllCurrency() throws NotFoundException {

		return new ResponseEntity<List<Currency>>(service.findAllCurrency(), HttpStatus.OK);

	}

	@RequestMapping(value = "/currency", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<Currency> updateCurrency(@RequestBody Currency currency) throws NotFoundException {

		return new ResponseEntity<Currency>(service.updateCurrency(currency), HttpStatus.OK);

	}

	@RequestMapping(value = "/currency", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Currency> addCurrency(@RequestBody Currency currency) throws NotFoundException {

		return new ResponseEntity<Currency>(service.addCurrency(currency), HttpStatus.OK);

	}

	@RequestMapping(value = "/currency/{id}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.GET)
	public ResponseEntity<Currency> findByIdCurrency(@PathVariable("id") Integer id) throws NotFoundException {

		return new ResponseEntity<Currency>(service.findByIdCurrency(id), HttpStatus.OK);

	}

	@RequestMapping(value = "/currency/{id}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCurrency(@PathVariable("id") Integer id) throws NotFoundException {

		service.deleteCurrency(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
