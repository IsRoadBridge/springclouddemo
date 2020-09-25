package com.zxq.spring.service.impl;

import com.zxq.spring.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignFallbackServiceImpl implements FeignService {

    @Override
    public String selectLb() {
        return "执行Feign自带的fallback";
    }
}
