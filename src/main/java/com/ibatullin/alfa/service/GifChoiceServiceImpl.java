package com.ibatullin.alfa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibatullin.alfa.exception.CurrentException;
import com.ibatullin.alfa.model.CurrencyModel;
import com.ibatullin.alfa.model.GifModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;


@Data
@Slf4j(topic = "GifOnCurrencyExchangeRateService")
@Service
public class GifChoiceServiceImpl implements GifChoiceService {
    private final GifService gifService;
    private final CurrencyService currencyService;
    private final DisplayGifService displayGifService;

    public ResponseEntity<byte[]> getGifByCurrency(String base) {
        log.info("Поиск гифки по курсу начат");
        if (isBaseNotValid(base)) {
            log.error("Код валюты невалиден");
            throw new CurrentException("Код валюты должна состоять из 3х символов");
        }
        log.info("Текущий код валюты: {}", base);
        String todayDate = formatDateFromNow(0);
        String yesterdayDate = formatDateFromNow(1);
        double todayRate = getRateByDateAndBase(todayDate, base);
        double yesterdayRate = getRateByDateAndBase(yesterdayDate, base);
        String tag = (todayRate > yesterdayRate) ? "rich" : "broke";
        log.info("Текущий tag для валюты: {}", tag);
        URI uri = URI.create(getGifUrlByTag(tag));
        return displayGifService.getGifByUrl(uri);
    }

    private boolean isBaseNotValid(String base) {
        return base.length() != 3;
    }

    private String formatDateFromNow(int days) {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(days);
        String dateFromNow = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(dateTime);
        log.info("Дата с учетом вычета {} дней : {}",days,dateFromNow);
        return dateFromNow;
    }

    private double getRateByDateAndBase(String date, String base) {
        CurrencyModel currencyModel = currencyService.getCurrency(date).getBody();
        double rate = 0;
        try {
             rate = Objects.requireNonNull(currencyModel).getRates().get(base);
        } catch (Throwable e) {
            throw new CurrentException("Введена некорректная валюта");
        }
        log.info("Курс на {}: {}",date,rate);
        return rate;
    }

    private String getGifUrlByTag(String tag) {
        Map map;
        Object obj;
        ObjectMapper oMapper = new ObjectMapper();
        GifModel gifModel = gifService.getGifResponse(tag).getBody();

        //Необходимый URL находится глубоко, решил достать еще через несколько map
        obj = Objects.requireNonNull(gifModel).getData();
        map = oMapper.convertValue(obj, Map.class);
        obj = oMapper.convertValue(map.get("images"), Map.class);
        map = oMapper.convertValue(obj, Map.class);
        obj = oMapper.convertValue(map.get("original"), Map.class);
        map = oMapper.convertValue(obj, Map.class);
        String url = String.valueOf(Objects.requireNonNull((map.get("url"))));
        log.info("Текущий URL гифки: {}", url);
        return url;
    }
}


