package com.zxq.spring.service;

import com.zxq.spring.service.impl.FeignFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-hystrix-payment-service",fallback = FeignFallbackService.class)
public interface FeignService {

    @GetMapping("/hystrix/payment/ok/{id}")
    public String getOk(@PathVariable("id") Long id);


    @GetMapping("/hystrix/payment/timeOut/{id}")
    public String getTimeout(@PathVariable("id") Long id);
}
