package com.zxq.spring.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zxq.spring.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;


    @GetMapping("/consumer/hystrix/payment/ok/{id}")
    public String getOk(@PathVariable("id") Long id){
        int i = 10/0;
        return  feignService.getOk(id);
    };


    @GetMapping("/consumer/hystrix/payment/timeOut/{id}")
    public String getTimeout(@PathVariable("id") Long id){

        return feignService.getTimeout(id);
    };


    /*public String getTimeOutError(Long id) {

        return "我是80消费端，对方服务器繁忙，请稍后再试"+"\t"+Thread.currentThread().getName()+"\t"+"id:"+id+"\t"+"┭┮﹏┭┮呜呜";

    }

    public String globalFallback() {

        return "这是一个默认的全局异常处理的服务降级"+"\t"+Thread.currentThread().getName()+"\t"+"\t"+"┭┮﹏┭┮呜呜";

    }*/

}
