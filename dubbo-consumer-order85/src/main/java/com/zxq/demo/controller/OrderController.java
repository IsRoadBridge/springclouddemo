package com.zxq.demo.controller;


import com.zxq.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/consumer/getUser")
    public String getUser(String name) {
        return orderService.initUser(name);
    }
}
