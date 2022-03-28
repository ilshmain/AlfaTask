package com.ibatullin.alfa.controller;

import com.ibatullin.alfa.service.GifChoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final GifChoiceService gif;

    @GetMapping("/gif")
    public ResponseEntity<byte[]> getGifByCurrency(@RequestParam(required = false) String base,
                                                   @Value("${default.currency}") String usd)
    {
        base = base == null ? usd : base;
        return gif.getGifByCurrency(base);
    }
}