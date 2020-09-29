package com.zxq.spring.service.impl;

import com.zxq.spring.dao.OrderMapper;
import com.zxq.spring.domain.Order;
import com.zxq.spring.service.AccountFeignService;
import com.zxq.spring.service.OrderService;
import com.zxq.spring.service.StorageFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AccountFeignService accountFeignService;
    @Autowired
    private StorageFeignService storageFeignService;

    @GlobalTransactional(name = "order-create",rollbackFor = Exception.class)
    @Override
    public void createOrder(Order order) {
        log.info("===开始创建支付订单");
        orderMapper.create(order);
        log.info("===创建支付订单完成");
        log.info("===开始减去用户余额");
        accountFeignService.deCreate(order.getUserId(), order.getMoney());
        log.info("===用户余额扣除完成");
        log.info("===开始扣除库存");
        storageFeignService.deCreate(order.getProductId(), order.getCount());
        log.info("===库存扣除完成");
        log.info("===开始修改订单状态");
        orderMapper.update(order.getUserId(), 0);
        log.info("===订单修改完成");
    }
}
