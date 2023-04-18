package com.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class LianXiService {
    public void service(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000));
        threadPoolExecutor.execute(()->{
            int i = 0 ;
            while(true){
                try {
                    i++;
                    Thread.sleep(1000);
                    System.out.println("service api invoking");
                    if(i==9){
                        break;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("service api invoke");
        });

    }

    public static void main(String[] args) {
        LianXiService ll=new LianXiService();
        ll.service();
        System.out.println("test over");
    }
}
