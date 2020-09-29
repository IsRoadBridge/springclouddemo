package com.zxq.spring.controller;

import com.zxq.spring.domain.ResultComment;
import com.zxq.spring.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/storage/deCreate")
    public ResultComment deCreate(@RequestParam("productId") Long productId,
                                  @RequestParam("count") Integer count){
        storageService.deCreate(productId,count);
        return  new ResultComment(200,"削减库存完成",null);
    }
}
