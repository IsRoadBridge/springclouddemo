package com.zxq.spring.service;

import com.zxq.spring.service.impl.FeignFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@Component
@FeignClient(value = "nacos-provider-service",fallback = FeignFallbackServiceImpl.class)
public interface FeignService {

    @GetMapping("/select")
    public  String  selectLb();
}
