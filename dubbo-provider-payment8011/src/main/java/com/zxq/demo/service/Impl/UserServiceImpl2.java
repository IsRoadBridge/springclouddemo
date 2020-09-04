package com.zxq.demo.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zxq.demo.service.UserService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Service(version = "2.0")
public class UserServiceImpl2 implements UserService {


    @Override
    public String getMap(String name) {
        Map<String,String> map = new HashMap<>();
        System.out.println("======new======");
        try {
            Thread.sleep(4000);
            map.put("zxq","1");
            map.put("zlq","12");
            map.put("bridge","123");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return map.get(name);
    }
}
