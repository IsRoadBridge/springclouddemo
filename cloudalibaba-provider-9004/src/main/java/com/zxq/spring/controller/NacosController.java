package com.zxq.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class NacosController {

    @Value("${server.port}")
    private  String serverPort;


    @GetMapping("/select")
    public  String  selectLb(){
        return  "serverPort:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
