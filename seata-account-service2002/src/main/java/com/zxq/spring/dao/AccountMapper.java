package com.zxq.spring.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
@Mapper
public interface AccountMapper {

    void deCreate(@Param("userId") Long userId,@Param("money") BigDecimal money);
}

