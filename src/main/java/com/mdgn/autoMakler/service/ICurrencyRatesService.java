package com.mdgn.autoMakler.service;

import com.mdgn.autoMakler.dto.CurrencyRatesResponse;

public interface ICurrencyRatesService {

	public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate);
}
