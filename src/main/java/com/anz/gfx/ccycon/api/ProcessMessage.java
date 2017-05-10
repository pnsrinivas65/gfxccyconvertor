package com.anz.gfx.ccycon.api;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anz.gfx.ccycon.api.service.AuditApiService;
import com.anz.gfx.ccycon.api.service.CurrencyApiService;
import com.anz.gfx.ccycon.api.service.DailycurrencyApiService;
import com.anz.gfx.ccycon.exception.InvalidCurrencyCombination;
import com.anz.gfx.ccycon.exception.NotFoundCurrencyException;
import com.anz.gfx.ccycon.exception.NotFoundException;
import com.anz.gfx.ccycon.model.Audit;
import com.anz.gfx.ccycon.model.Currency;
import com.anz.gfx.ccycon.model.CurrencyConvertor;
import com.anz.gfx.ccycon.model.Dailycurrency;


@RestController
@RequestMapping(value = "/api")
public class ProcessMessage implements MessageProcessor {

	@Autowired
	private DailycurrencyApiService dailyCCyservice;

	@Autowired
	private CurrencyApiService ccyService;

	@Autowired
	private AuditApiService auditService;
	
	@Value("${spring.rest.fxhost}")
	String restApiFX;
	
	@Value("${spring.gfx.user1}")
	String GFX1;

	@Value("${spring.gfx.user2}")
	String GFX2;

	@Value("${spring.gfx.user3}")
	String GFX3;

	
	@RequestMapping(value = "/convertccys", produces = { "application/json" }, 
			consumes = {"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<CurrencyConvertor> processConversion(@RequestBody 
		CurrencyConvertor ccyCon ) throws Exception {
		
		Audit requestLog = processRequest(ccyCon);

		Currency frmCcy = ccyService.findByCurrencycode(ccyCon.getFrmCcy());
		Currency toCcy = ccyService.findByCurrencycode(ccyCon.getToCcy());
		
		if(frmCcy == null || toCcy == null ) {
			throw new NotFoundCurrencyException("Please Choose Proper "
					+ " Currency for conversion");
		}

		String url = restApiFX;
		RestTemplate restTemplate = new RestTemplate();
		
		
		url = restApiFX + frmCcy.getCurrencycode();
		
		ResponseEntity<String> response 	= restTemplate.exchange(url, 
				HttpMethod.GET, null, String.class);
		JSONObject fxJson = new JSONObject(response.getBody());
		
		String date = fxJson.optString("date");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		JSONObject rates = fxJson.optJSONObject("rates");
		if(Double.isNaN(rates.optDouble(ccyCon.getToCcy()))) {
			throw new InvalidCurrencyCombination("User has to choose "
					+ "From and To different Currency Combination");
		}
		
		
		BigDecimal conversionrate = new BigDecimal(rates.optDouble(ccyCon.
				getToCcy()));
		BigDecimal inversionrate = new BigDecimal(1).divide(conversionrate, 
				5, BigDecimal.ROUND_HALF_UP);
		
		Dailycurrency fxDlyCcy = new Dailycurrency();
		fxDlyCcy.setId(requestLog.getId());
		fxDlyCcy.setFrmccy(frmCcy);
		fxDlyCcy.setToccy(toCcy);
		fxDlyCcy.setConversiondate(sdf.parse(date));
		fxDlyCcy.setConversionrate(conversionrate);
		fxDlyCcy.setInversionrate(inversionrate);
		fxDlyCcy.setCreatedby(GFX1);
		fxDlyCcy.setCreationtimestamp(new Date(System.currentTimeMillis()));
		dailyCCyservice.addDailycurrency(fxDlyCcy);
	
		BigDecimal amount = ccyCon.getFromAmount();
		ccyCon.setToAmount(amount.multiply(conversionrate).
			setScale(toCcy.getDecimalplace(), BigDecimal.ROUND_HALF_UP));
		ccyCon.setConversionRate(conversionrate);
		
		requestLog.setRequest(ccyCon.toString());
		requestLog.setUpdatedby(GFX2);
		requestLog.setUpdationtimestamp(new Date(System.currentTimeMillis()));
		auditService.updateAudit(requestLog);

		return new ResponseEntity<CurrencyConvertor>(ccyCon, HttpStatus.OK);
	}

	private Audit processRequest(CurrencyConvertor ccyCon) 
			throws NotFoundException {
		Audit requestlog = new Audit();
		requestlog.setRequest(ccyCon.toString());
		requestlog.setCreatedby(GFX1);
		requestlog.setUpdatedby(GFX2);
		requestlog.setCreationtimestamp(new Date(
				System.currentTimeMillis()));
		requestlog.setUpdationtimestamp(new Date(
				System.currentTimeMillis()));
		auditService.addAudit(requestlog);
		return requestlog;
	}	
}