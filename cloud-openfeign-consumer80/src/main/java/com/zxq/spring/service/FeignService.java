package com.zxq.spring.service;

import com.zxq.spring.entity.CommentResult;
import com.zxq.spring.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service")
public interface FeignService {

    @GetMapping("/payment/select/{id}")
    public CommentResult<Payment> get(@PathVariable("id") Long id);

    @GetMapping("/payment/timeOut")
    public  String paymentTimeOut();
}
