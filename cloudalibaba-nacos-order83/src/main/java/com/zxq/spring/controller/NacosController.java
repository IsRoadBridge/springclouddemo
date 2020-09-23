package com.zxq.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosController {

    @Value("${service-url.nacos-provider-service}")
    private  String serviceURL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/nacos/{id}")
    public  String nacos(@PathVariable("id") Integer id){
        return  restTemplate.getForObject(serviceURL+"/nacos/"+id,String.class);
    }
}
