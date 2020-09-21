package com.zxq.spring;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

public class TestTime {

    @Test
    public  void  testData(){

        ZonedDateTime zbj = ZonedDateTime.now();
        System.out.println(zbj);
    }
}
