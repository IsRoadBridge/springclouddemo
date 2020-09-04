package com.zxq.demo.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zxq.demo.service.OrderService;
import com.zxq.demo.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

    @Reference(timeout = 1000,retries = 2,version = "*")
    private UserService userService;

    @Override
    public String initUser(String name) {
        return userService.getMap(name);
    }
}
