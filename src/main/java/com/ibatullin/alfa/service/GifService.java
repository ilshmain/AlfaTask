package com.ibatullin.alfa.service;

import com.ibatullin.alfa.dto.GifDTO;
import org.springframework.http.ResponseEntity;

public interface GifService {
    ResponseEntity<GifDTO> getGifResponse(String tag);
}