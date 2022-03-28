package com.ibatullin.alfa.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

//https://stackoverflow.com/questions/43733569/how-can-i-change-the-feign-url-during-the-runtime
@FeignClient(name = "download-gif-client", url = "${example.url}")
public interface DisplayApi {
    @GetMapping
    ResponseEntity<byte[]> getGifByUrl(URI baseUrl);
}
