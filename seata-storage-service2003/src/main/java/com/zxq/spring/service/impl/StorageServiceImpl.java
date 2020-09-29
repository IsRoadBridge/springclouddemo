package com.zxq.spring.service.impl;

import com.zxq.spring.dao.StorageMapper;
import com.zxq.spring.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    private  static  final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void deCreate(Long productId, Integer count) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("=====开始削减库存");
        storageMapper.deCreate(productId,count);
        LOGGER.info("=====库存削减完成");
    }
}
