package com.zxq.spring.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StorageMapper {

    void  deCreate(@Param("productId") Long productId,@Param("count") Integer count);
}
