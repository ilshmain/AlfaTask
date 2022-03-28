package com.ibatullin.alfa.api;

import com.ibatullin.alfa.dto.CurrencyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currency", url = "${currency.url}")
public interface CurrencyApi {
    @GetMapping("/{date}.json")
    ResponseEntity<CurrencyDTO> getCurrency(@PathVariable("date") String date, @RequestParam("app_id") String id);
}

