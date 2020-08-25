package com.zxq.spring.service.impl;

import com.zxq.spring.dao.PaymentMapper;
import com.zxq.spring.entity.Payment;
import com.zxq.spring.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment selectById(Long id) {
        return paymentMapper.selectById(id);
    }
}
