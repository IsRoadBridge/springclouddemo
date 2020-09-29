package com.zxq.spring.controller;

import com.zxq.spring.domain.Order;
import com.zxq.spring.domain.ResultComment;
import com.zxq.spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("order/orderCreate")
    public ResultComment orderCreate(Order order){
        orderService.createOrder(order);
        return  new ResultComment(200,"订单支付成功",null);
    }

}
