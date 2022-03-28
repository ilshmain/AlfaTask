package com.ibatullin.alfa.service;

import org.springframework.http.ResponseEntity;

public interface GifChoiceService {
    ResponseEntity<byte[]> getGifByCurrency(String base);
}
