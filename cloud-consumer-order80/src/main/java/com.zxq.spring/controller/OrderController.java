package com.zxq.spring.controller;

import com.zxq.spring.entity.CommentResult;
import com.zxq.spring.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class OrderController {

//    private  static  final String PAYMENT_URL="http://localhost:8001";
      private  static  final String PAYMENT_URL="http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommentResult<Payment> paymentInsert(Payment payment){
      return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommentResult.class);
    }

    @GetMapping("/payment/select/{id}")
    public CommentResult<Payment> paymentGetById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/select/"+id,CommentResult.class);
    }
}
