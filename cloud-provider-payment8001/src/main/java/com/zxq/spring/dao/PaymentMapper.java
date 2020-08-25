package com.zxq.spring.dao;

import com.zxq.spring.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface PaymentMapper {

    int create(Payment payment);

    Payment selectById(@Param("id") Long id);
}
