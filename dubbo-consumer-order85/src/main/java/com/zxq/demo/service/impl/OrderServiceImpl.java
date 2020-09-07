package com.zxq.demo.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zxq.demo.service.OrderService;
import com.zxq.demo.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

    @Reference
    private UserService userService;

    @HystrixCommand(fallbackMethod = "checkService")
    @Override
    public String initUser(String name) {
        return userService.getMap(name);
    }


    public String checkService(String name){
        return  "调用服务发生错误,现在是服务容错";
    }

}
