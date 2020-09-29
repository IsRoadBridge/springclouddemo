package com.zxq.spring.service;

import com.zxq.spring.domain.ResultComment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountFeignService {

    @RequestMapping("/account/deCreate")
    public ResultComment deCreate(@RequestParam("userId") Long userId,
                                  @RequestParam("money") BigDecimal money);
}
