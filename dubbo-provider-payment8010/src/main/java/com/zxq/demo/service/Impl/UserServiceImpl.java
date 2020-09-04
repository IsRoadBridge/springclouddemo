package com.zxq.demo.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zxq.demo.service.UserService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Service
public class UserServiceImpl implements UserService {


    @Override
    public String getMap(String name) {
        Map<String,String> map = new HashMap<>();
        map.put("zxq","1");
        map.put("zlq","12");
        map.put("bridge","123");

        return map.get(name);
    }
}
