package com.ibatullin.alfa.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GifChoiceServiceTest {

    @Autowired
    private GifChoiceService gif;

    @Test
    public void getGifByCurrency() {
        ResponseEntity<byte[]> gifResponse  = gif.getGifByCurrency("USD");
        assertAll(
                () -> assertEquals(gifResponse.getStatusCodeValue(), 200),
                () -> assertNotNull(Objects.requireNonNull(gifResponse.getBody()))
        );
    }
}