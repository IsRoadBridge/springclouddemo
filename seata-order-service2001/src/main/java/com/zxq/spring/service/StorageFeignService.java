package com.zxq.spring.service;

import com.zxq.spring.domain.ResultComment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageFeignService {


    @RequestMapping("/storage/deCreate")
    public ResultComment deCreate(@RequestParam("productId") Long productId,
                                  @RequestParam("count") Integer count);
}
