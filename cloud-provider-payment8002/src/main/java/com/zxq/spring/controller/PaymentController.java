package com.zxq.spring.controller;

import com.zxq.spring.entity.CommentResult;
import com.zxq.spring.entity.Payment;
import com.zxq.spring.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/payment/create")
    public CommentResult<Payment> create(@RequestBody Payment payment){
        int number = paymentService.create(payment);
        log.info("=======查询结果为:"+number);
        if (number>0){
            return new CommentResult(200,"新增成功,serverPort:"+serverPort,number);
        }else{
            return new CommentResult(444,"新增失败",number);
        }
    }

    @GetMapping("/payment/select/{id}")
    public CommentResult<Payment> select(@PathVariable("id") Long id){
        Payment payment = paymentService.selectById(id);
        if (payment!=null){
            return new CommentResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else{
            return new CommentResult(444,"没有该id为"+id+"的数据",null);
        }
    }

    //设置该方法超时时间为3秒
    @GetMapping("/payment/timeOut")
    public  String paymentTimeOut()  {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
