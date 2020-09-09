package com.zxq.spring.controller;


import com.zxq.spring.entity.CommentResult;
import com.zxq.spring.entity.Payment;
import com.zxq.spring.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @GetMapping("/feign/consumer/payment/select/{id}")
    public CommentResult<Payment> get(@PathVariable("id") Long id){
        return  feignService.get(id);
    }

    @GetMapping("/feign/consumer/payment/timeOut")
    public  String paymentTimeOut(){
        return feignService.paymentTimeOut();
    }
}
