package com.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;
    @Override
    public Exception decode(String s, Response response) {
        InputStream inputStream = null;
        byte[] body = null;
        Map<String,Object> map = null;
        try {
            inputStream = response.body().asInputStream();
            body = Util.toByteArray(inputStream);
            map = objectMapper.readValue(body, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new AppException(map.get("code").toString(),map.get("message").toString(),
                HttpStatus.valueOf(response.status()));
    }
}
