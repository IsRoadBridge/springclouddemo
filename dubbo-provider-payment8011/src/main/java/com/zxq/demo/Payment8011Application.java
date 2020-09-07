package com.zxq.demo;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;


@EnableDubbo
@EnableHystrix
@SpringBootApplication
public class Payment8011Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment8011Application.class, args);
    }

}
