package com.zxq.spring.service.impl;

import com.zxq.spring.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignFallbackService implements FeignService {
    @Override
    public String getOk(Long id) {
        return "getOk解决代码混乱的fallback,当提供者宕机时也可以处理异常";
    }

    @Override
    public String getTimeout(Long id) {
        return "getTimeout异常处理";
    }
}
