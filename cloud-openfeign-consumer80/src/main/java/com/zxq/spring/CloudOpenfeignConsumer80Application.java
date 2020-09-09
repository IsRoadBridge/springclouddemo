package com.zxq.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CloudOpenfeignConsumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudOpenfeignConsumer80Application.class, args);
    }

}
