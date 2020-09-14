package com.zxq.spring.service;

public interface HystrixService {

    String getOk(Long id);

    String getTimeOut(Long id);

    String getPaymentCircultBreak(Long id);
}
