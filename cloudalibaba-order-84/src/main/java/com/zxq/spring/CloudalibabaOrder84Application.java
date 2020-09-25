package com.zxq.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CloudalibabaOrder84Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaOrder84Application.class, args);
    }

}
