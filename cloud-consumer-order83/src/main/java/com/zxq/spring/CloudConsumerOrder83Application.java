package com.zxq.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudConsumerOrder83Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder83Application.class, args);
    }

}
