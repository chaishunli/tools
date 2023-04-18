package com.Controller;

import com.config.AppException;
import com.feignclient.LianXiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        Cookie cookie =new Cookie("token","456");
        cookie.setDomain("127.0.0.1:8080");
        cookie.setPath("/test");
        response.addCookie(cookie);
        Map<String,Object> map  = lianXiClient.get2();
        return map;
    }

    @GetMapping("/lianxi")
    public Map<String, Object> get2(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        return new HashMap<String,Object>();
    }
}
