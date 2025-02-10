package com.mdgn.autoMakler.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdgn.autoMakler.controller.IRestCurrencyRatesController;
import com.mdgn.autoMakler.controller.RestBaseController;
import com.mdgn.autoMakler.controller.RootEntity;
import com.mdgn.autoMakler.dto.CurrencyRatesResponse;
import com.mdgn.autoMakler.service.ICurrencyRatesService;

@RestController
@RequestMapping ("/rest/api/")
public class RestCurrencyRatesControllerImpl extends RestBaseController implements IRestCurrencyRatesController{

	@Autowired
	private ICurrencyRatesService currencyRatesService;
	
	
	@GetMapping("/currency-rates")
	@Override
	public RootEntity<CurrencyRatesResponse> getCurrencyRates(

		@RequestParam("startDate") String startDate, @RequestParam ("endDate") String endDate){//hocanınkinde ikinci parametre de startdate*****
		return ok(currencyRatesService.getCurrencyRates(startDate, endDate));
	}

	
	
	
}
