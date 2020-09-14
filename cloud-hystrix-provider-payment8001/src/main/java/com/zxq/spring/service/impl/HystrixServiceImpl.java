package com.zxq.spring.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zxq.spring.service.HystrixService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class HystrixServiceImpl implements HystrixService {


    @Override
    public String getOk(Long id) {
        return "这是一次成功的调用"+"\t"+Thread.currentThread().getName()+"\t"+"id:"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "getTimeOutError",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @Override
    public String getTimeOut(Long id) {
        // int i = 7/0;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "这是一次超时的调用"+"\t"+Thread.currentThread().getName()+"\t"+"id:"+id+"\t"+"┭┮﹏┭┮呜呜";

    }

    public String getTimeOutError(Long id) {

        return "8001服务器超时或者运行异常"+"\t"+Thread.currentThread().getName()+"\t"+"id:"+id+"\t"+"┭┮﹏┭┮呜呜";

    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "getCircultBreak",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "100000"), // 过多长时间恢复，时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    @Override
    public String getPaymentCircultBreak(Long id) {
        if (id<0){
            throw  new RuntimeException("=====id不能为负数");
        }
        return  "调用成功"+"\t"+Thread.currentThread().getName()+"\t"+"id:"+id+"\t流水号："+UUID.randomUUID().toString();
    }

    public String getCircultBreak(Long id) {
        return  "服务熔断测试"+"\t"+Thread.currentThread().getName()+"\t"+"id:"+id+"为负数，调用失败";
    }

}
