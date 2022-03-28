package com.ibatullin.alfa.service;

import com.ibatullin.alfa.api.DisplayApi;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.net.URI;

@Service
@Data
public class DisplayGifServiceImpl implements DisplayGifService {
    private final DisplayApi displayApi;

    @Override
    public ResponseEntity<byte[]> getGifByUrl(URI uri) {
        return displayApi.getGifByUrl(uri);
    }
}

