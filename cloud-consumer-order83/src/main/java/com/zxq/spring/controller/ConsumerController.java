package com.zxq.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private  static  final String PAYMENT_URL="http://zookeeper-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zK")
    public String paymentInsert(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zK",String.class);
    }

}
