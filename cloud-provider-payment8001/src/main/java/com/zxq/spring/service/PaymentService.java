package com.zxq.spring.service;

import com.zxq.spring.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int create(Payment payment);

    Payment selectById(@Param("id") Long id);
}
