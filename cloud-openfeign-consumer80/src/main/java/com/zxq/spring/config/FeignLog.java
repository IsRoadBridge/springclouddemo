package com.zxq.spring.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLog {

    @Bean
    Logger.Level getFeignLogger(){
        return  Logger.Level.FULL;
    }
}
