package com.zxq.spring.service.impl;

import com.zxq.spring.dao.AccountMapper;
import com.zxq.spring.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void deCreate(Long userId, BigDecimal money) {
        LOGGER.info("=====开始扣除账户余额");
        accountMapper.deCreate(userId, money);
        LOGGER.info("=====扣除账户余额完成");
    }
}
