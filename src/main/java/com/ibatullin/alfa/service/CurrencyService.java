package com.ibatullin.alfa.service;

import com.ibatullin.alfa.model.CurrencyModel;
import org.springframework.http.ResponseEntity;

public interface CurrencyService {
    ResponseEntity<CurrencyModel> getCurrency(String date);
}
