package com.zxq.demo.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zxq.demo.service.UserService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Service
public class UserServiceImpl implements UserService {


    @HystrixCommand
    @Override
    public String getMap(String name) {
        Map<String,String> map = new HashMap<>();
        System.out.println("======2222======");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            map.put("zxq","1");
            map.put("zlq","12");
            map.put("bridge","123");

        return map.get(name);
    }
}
