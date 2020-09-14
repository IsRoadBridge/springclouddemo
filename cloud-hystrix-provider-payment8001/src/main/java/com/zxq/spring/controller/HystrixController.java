package com.zxq.spring.controller;

import com.zxq.spring.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/payment/ok/{id}")
    public String getOk(@PathVariable("id") Long id) {
        String result = hystrixService.getOk(id);
        log.info(result);
        return  result;
    }


    @GetMapping("/hystrix/payment/timeOut/{id}")
    public String getTimeout(@PathVariable("id") Long id) {
        String result = hystrixService.getTimeOut(id);
        log.info(result);
        return  result;
    }

    @GetMapping("/hystrix/payment/getPaymentCircultBreak/{id}")
    public String getPaymentCircultBreak(@PathVariable("id") Long id) {
        String result = hystrixService.getPaymentCircultBreak(id);
        log.info(result);
        return  result;
    }
}
