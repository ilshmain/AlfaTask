package com.ibatullin.alfa.service;

import com.ibatullin.alfa.model.GifModel;
import org.springframework.http.ResponseEntity;

public interface GifService {
    ResponseEntity<GifModel> getGifResponse(String tag);
}