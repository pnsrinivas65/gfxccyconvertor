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

import com.anz.gfx.ccycon.api.service.DailycurrencyApiService;
import com.anz.gfx.ccycon.exception.NotFoundException;
import com.anz.gfx.ccycon.model.Dailycurrency;

@RestController
@RequestMapping(value = "/api")
public class DailycurrencyApi {

	@Autowired
	private DailycurrencyApiService service;

	@RequestMapping(value = "/dailycurrency", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.GET)
	public ResponseEntity<List<Dailycurrency>> findAllDailycurrency() throws NotFoundException {

		return new ResponseEntity<List<Dailycurrency>>(service.findAllDailycurrency(), HttpStatus.OK);
	}

	@RequestMapping(value = "/dailycurrency", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<Dailycurrency> updateDailycurrency(@RequestBody Dailycurrency dailycurrency)
			throws NotFoundException {

		return new ResponseEntity<Dailycurrency>(service.updateDailycurrency(dailycurrency), HttpStatus.OK);
	}

	@RequestMapping(value = "/dailycurrency", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Dailycurrency> addDailycurrency(@RequestBody Dailycurrency dailycurrency)
			throws NotFoundException {

		
		
		return new ResponseEntity<Dailycurrency>(service.addDailycurrency(dailycurrency), HttpStatus.OK);
	}

	@RequestMapping(value = "/dailycurrency/{id}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.GET)
	public ResponseEntity<Dailycurrency> findByIdDailycurrency(@PathVariable("id") Integer id)
			throws NotFoundException {

		return new ResponseEntity<Dailycurrency>(service.findByIdDailycurrency(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/dailycurrency/{id}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDailycurrency(@PathVariable("id") Integer id) throws NotFoundException {

		service.deleteDailycurrency(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}