package com.zxq.spring.controller;

import com.zxq.spring.entity.CommentResult;
import com.zxq.spring.entity.Payment;
import com.zxq.spring.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
  /*  @Resource
    private DiscoveryClient discoveryClient;*/

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

    @GetMapping("/payment/sleuth")
    public String sleuth(){
        return "这是一次8001的调用";
    }

    //设置该方法超时时间为3秒
    @GetMapping("/payment/timeOut")
    public  String paymentTimeOut()  {
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

//    @GetMapping("/payment/discovery")
//    public  DiscoveryClient getDiscoveryClient(){
//        //通过discoveryClient.getServices()方法查看注册的服务有哪些
//        List<String> services = discoveryClient.getServices();
//        for (String element:services){
//            log.info("====element:"+element);
//        }
//        //通过discoveryClient.getInstances("某个服务")来查看该服务下有哪些实例，以及这些实例的名称，主机地址，端口，url
//        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
//        for (ServiceInstance instance:instances){
//            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
//        }
//        return discoveryClient;
//    }
//    /*执行结果
//    *INFO 14436 --- [nio-8001-exec-7] c.z.spring.com.zxq.spring.controller.PaymentController  : ====element:cloud-payment-service
//     INFO 14436 --- [nio-8001-exec-7] c.z.spring.com.zxq.spring.controller.PaymentController  : payment8001	192.168.31.124	8001	http://192.168.31.124:8001
//     INFO 14436 --- [nio-8001-exec-7] c.z.spring.com.zxq.spring.controller.PaymentController  : payment8002	192.168.31.124	8002	http://192.168.31.124:8002*/
}
