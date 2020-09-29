package com.zxq.spring.dao;

import com.zxq.spring.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderMapper {

    void  create(Order order);

    void  update(@Param("userId") Long userId,@Param("status") Integer status);
}
