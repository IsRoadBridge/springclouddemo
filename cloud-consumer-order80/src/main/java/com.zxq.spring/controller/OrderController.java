package com.zxq.spring.controller;

import com.zxq.spring.entity.CommentResult;
import com.zxq.spring.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
@Slf4j
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

    @GetMapping("/consumer/payment/sleuth")
    public String sleuth(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/sleuth",String.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommentResult<Payment> paymentGetById2(@PathVariable("id") Long id){
        ResponseEntity<CommentResult> entity= restTemplate.getForEntity(PAYMENT_URL+"/payment/select/"+id,CommentResult.class);
        log.error(entity.getHeaders()+"\t"+entity.getStatusCode()+"\t"+entity.getStatusCodeValue()
        +"\t"+entity.getBody());
        if (entity.getStatusCode().is2xxSuccessful()){
            return  entity.getBody();
        }else{
            return  new CommentResult<Payment>(444,"操作失败",null);
        }
    }

    //[Content-Type:"application/json", Transfer-Encoding:"chunked", Date:"Wed, 09 Sep 2020 06:59:52 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]	200 OK	200	CommentResult(code=200, message=查询成功,serverPort:8001, data={id=2, serial=zxqqq})
}
