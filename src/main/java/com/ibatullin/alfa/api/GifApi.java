package com.ibatullin.alfa.api;

import com.ibatullin.alfa.model.GifModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gif-client", url = "${gif.url}")
public interface GifApi {
    @GetMapping(value = "/random")
    ResponseEntity<GifModel> getGif(@RequestParam("api_key") String api_key,
                                    @RequestParam("tag") String tag);
}
