package com.mdgn.autoMakler.controller;

import com.mdgn.autoMakler.dto.CurrencyRatesResponse;

public interface IRestCurrencyRatesController {
	
	public RootEntity <CurrencyRatesResponse> getCurrencyRates(String startDate, String endDate);

}
