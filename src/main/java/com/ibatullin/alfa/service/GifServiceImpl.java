package com.ibatullin.alfa.service;

import com.ibatullin.alfa.api.GifApi;
import com.ibatullin.alfa.dto.GifDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
public class GifServiceImpl implements GifService {

    private final GifApi gifApi;
    private final String API_KEY;

    public GifServiceImpl(GifApi gifApi, @Value("${gif.api_key}") String API_KEY) {
        this.gifApi = gifApi;
        this.API_KEY = API_KEY;
    }

    public ResponseEntity<GifDTO> getGifResponse(String tag) {
        return gifApi.getGif(API_KEY, tag);
    }
}
