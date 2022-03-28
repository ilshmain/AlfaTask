package com.ibatullin.alfa.service;

import com.ibatullin.alfa.model.CurrencyModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CurrencyServiceTest {

    @Autowired
    private CurrencyService currencyService;

    @Test
    public void getCurrencyTrue() {
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.now());
        ResponseEntity<CurrencyModel> response = currencyService.getCurrency(date);
        assertAll(
                () -> assertEquals(response.getStatusCodeValue(), 200),
                () -> assertNotNull(Objects.requireNonNull(response.getBody()).getRates().get("RUB"))
        );
    }

    @Test
    public void getCurrencyFalse() {
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.now());
        ResponseEntity<CurrencyModel> response = currencyService.getCurrency(date);
        assertAll(
                () -> assertEquals(response.getStatusCodeValue(), 200),
                () -> assertNull(Objects.requireNonNull(response.getBody()).getRates().get("OPQ"))
        );
    }
}
