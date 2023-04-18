package com.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(
        name = "localhost:8080",
        url = "localhost:8080"
)
public interface LianXiClient {
    @GetMapping("/lianxi")
    public Map<String, Object> get2();
}
