package com.ibatullin.alfa.service;

import com.ibatullin.alfa.api.CurrencyApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ibatullin.alfa.dto.CurrencyDTO;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyApi currencyApi;
    private final String API_KEY;

    public CurrencyServiceImpl(CurrencyApi currencyApi, @Value("${currency.api_key}") String API_KEY) {
        this.currencyApi = currencyApi;
        this.API_KEY = API_KEY;
    }

    public ResponseEntity<CurrencyDTO> getCurrency(String date) {
        return currencyApi.getCurrency(date, API_KEY);
    }
}
