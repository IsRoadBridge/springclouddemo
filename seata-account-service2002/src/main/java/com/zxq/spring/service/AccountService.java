package com.zxq.spring.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountService {

    void deCreate( Long userId,  BigDecimal money);
}
