package com.Controller;

import com.config.AppException;
import com.feignclient.LianXiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LianXiController {
    private final LianXiClient lianXiClient;
    @GetMapping
    public Map<String, Object> get(HttpServletRequest request, HttpServletResponse response){
        return null;
    }

    @PostMapping("/info")
    public Map<String, Object> get2(@RequestBody Map map){
        if( 1==1 ) {
            throw new AppException("001", "ssdfasd", HttpStatus.BAD_GATEWAY);
        }
        return new HashMap<String,Object>();
    }
}
