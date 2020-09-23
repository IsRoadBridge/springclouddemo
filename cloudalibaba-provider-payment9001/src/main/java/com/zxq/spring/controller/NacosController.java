package com.zxq.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    @Value("${server.port}")
    private  String serverPort;


    @GetMapping("/nacos/{id}")
    public  String nacos(@PathVariable("id") Integer id){
        return "nacos register\t端口："+serverPort+"id:"+id;
    }
}
