package com.mdgn.autoMakler.service.impl;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mdgn.autoMakler.dto.CurrencyRatesResponse;
import com.mdgn.autoMakler.exception.BaseException;
import com.mdgn.autoMakler.exception.ErrorMessage;
import com.mdgn.autoMakler.exception.MessageType;
import com.mdgn.autoMakler.service.ICurrencyRatesService;

@Service
public class CurrencyRatesServiceImpl implements ICurrencyRatesService {

	@Override
	public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate) {
		//https://evds2.tcmb.gov.tr/service/evds/series=TP.DK.USD.A&startDate=07-02-2025&endDate=07-02-2025&type=json
		
		String rootUrl="https://evds2.tcmb.gov.tr/service/evds/";
		String series="TP.DK.USD.A";
		String type= "json";
		
		String endpoint = rootUrl+"series="+series+"&startDate="+startDate+"&endDate="+endDate+"&type="+type;
		
		
		HttpHeaders httpHeaders= new HttpHeaders();
		
		httpHeaders.set("key", "JGKs5Njc8Y");
		
		HttpEntity<?> httpEntity =new HttpEntity<>(httpHeaders);	
		RestTemplate restTemplate = new RestTemplate();

		try {
					ResponseEntity<CurrencyRatesResponse> response= restTemplate.exchange(endpoint, HttpMethod.GET,httpEntity, new ParameterizedTypeReference<CurrencyRatesResponse>() {} );
		response.getBody();
		if(response.getStatusCode().is2xxSuccessful()) {
			return response.getBody();
		}
		}catch (Exception e) {
						throw new BaseException(new ErrorMessage(MessageType.CURRENCY_RATES_IS_OCCURED,e.getMessage()));

		}
				
		return null;
	}

}
