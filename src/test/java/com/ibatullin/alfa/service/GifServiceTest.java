package com.ibatullin.alfa.service;

import com.ibatullin.alfa.model.GifModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GifServiceTest {

    @Autowired
    private GifService gifService;

    @Test
    public void getCurrencyTrue() {
        String tag = "rich";
        GifModel gifModel = gifService.getGifResponse(tag).getBody();
        assertNotNull(gifModel.getData());
    }
}