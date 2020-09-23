package com.zxq.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudalibabaNacosOrder83Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaNacosOrder83Application.class, args);
    }

}
