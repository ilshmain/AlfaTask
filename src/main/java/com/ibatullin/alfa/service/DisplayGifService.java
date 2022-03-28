
package com.ibatullin.alfa.service;

import org.springframework.http.ResponseEntity;

import java.net.URI;

public interface DisplayGifService {
    ResponseEntity<byte[]> getGifByUrl(URI url);
}

