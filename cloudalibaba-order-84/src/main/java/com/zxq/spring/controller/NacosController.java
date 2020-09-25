package com.zxq.spring.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zxq.spring.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosController {


    @Value("${service-url.nacos-provider-service}")
    private String serviceURL;

    @Autowired
    private RestTemplate restTemplate;

   @Autowired
   private  FeignService feignService;

    @GetMapping("/consumer/select")
    public  String  selectLb(){
        return  feignService.selectLb();
    }

    /*exceptionsToIgnore参数可以排除异常，花括号内可以填多个异常
    被该注解排除的异常将不会被fallback捕获，直接返回异常，其他的异常还是会走fallback
    例：当该方法发生IllegalArgumentException异常时就不会走fallback，直接抛出异常
    发生其他异常就还是走fallback
     */
    @SentinelResource(value = "select", fallback = "handlerFallback")
    @GetMapping("/consumer/select/{id}")
    public String nacos(@PathVariable("id") Integer id) {
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常====================");
        } else if (id > 4) {
            throw new NullPointerException("空指针异常");
        }
        return restTemplate.getForObject(serviceURL + "/select/", String.class);
    }

    public String handlerFallback(Integer id, Throwable e) {

        return "fallback执行+\t" + e.getMessage();
    }

    /*//当指定blockHandler的方法达到sentinel控制台的服务限流，服务降级时就会触发blockHandler
    //如果只是方法执行发生异常则不会调用blockHandler，直接会抛出异常
    public String blockHandler(Integer id, BlockException blockException) {

        return "blockHandler执行+\t";
    }*/
    /*
    * 当然blockHandler和fallback也可以同时配置在一个方法上，它们互不影响
    * 当发生方法运行时异常时就走fallback
    * 当触发了服务降级，服务限流等规则时就走blockHandler
    * */
}
