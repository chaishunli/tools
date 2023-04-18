package com.Controller;

import com.feignclient.LianXiClient;
import com.service.LianXiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LianXiControllerTest {

    @Autowired
    private LianXiService lianXiService;
    @Test
    public void test() throws InterruptedException {
        lianXiService.service();
        Thread.sleep(10000);
        System.out.println("test over");
    }
}
