package com.ibatullin.alfa.service;

import com.ibatullin.alfa.dto.CurrencyDTO;
import org.springframework.http.ResponseEntity;

public interface CurrencyService {
    ResponseEntity<CurrencyDTO> getCurrency(String date);
}
